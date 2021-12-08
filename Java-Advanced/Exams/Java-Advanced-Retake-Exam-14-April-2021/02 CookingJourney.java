import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookingJourney_2_14April2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int[] myPosition = new int[2];
        List<int[]> pillarsPosition = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine();
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = line.charAt(c);
                if (line.charAt(c) == 'S') {
                    myPosition[0] = r;
                    myPosition[1] = c;
                } else if (line.charAt(c) == 'P') {
                    pillarsPosition.add(new int[]{r, c});
                }
            }
        }

        int money = 0;
        while (true) {
            String command = scanner.nextLine();
            matrix[myPosition[0]][myPosition[1]] = '-';
            moveMyPosition(command, myPosition);

            if (!isInbound(matrix, myPosition)) {
                break;
            }

            char currentSymbol = matrix[myPosition[0]][myPosition[1]];
            if (currentSymbol == 'P') {
                matrix[myPosition[0]][myPosition[1]] = '-';
                pillarsPosition.removeIf(p -> p[0] == myPosition[0] && p[1] == myPosition[1]);
                myPosition[0] = pillarsPosition.get(0)[0];
                myPosition[1] = pillarsPosition.get(0)[1];
            } else if (Character.isDigit(currentSymbol)) {
                money += Character.getNumericValue(currentSymbol);
            }
            matrix[myPosition[0]][myPosition[1]] = 'S';

            if (money >= 50) {
                break;
            }
        }
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.println("Money: " + money);
        printMatrix(matrix);
    }

    private static void moveMyPosition(String command, int[] myPosition) {
        switch (command) {
            case "up":
                myPosition[0]--;
                break;
            case "down":
                myPosition[0]++;
                break;
            case "left":
                myPosition[1]--;
                break;
            case "right":
                myPosition[1]++;
                break;
        }
    }

    private static boolean isInbound(char[][] matrix, int[] myPosition) {
        return myPosition[0] >= 0 && myPosition[0] < matrix.length && myPosition[1] >= 0 && myPosition[1] < matrix.length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
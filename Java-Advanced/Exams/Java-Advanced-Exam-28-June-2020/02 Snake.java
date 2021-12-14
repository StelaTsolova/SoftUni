import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake_2_28June2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[sizeMatrix][sizeMatrix];
        List<int[]> lairsPosition = new ArrayList<>();
        int[] snakePosition = new int[2];
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine();
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = line.charAt(c);
                if (line.charAt(c) == 'S') {
                    snakePosition[0] = r;
                    snakePosition[1] = c;
                } else if (line.charAt(c) == 'B') {
                    lairsPosition.add(new int[]{r, c});
                }
            }
        }

        int foods = 0;
        while (foods < 10) {
            String command = scanner.nextLine();
            matrix[snakePosition[0]][snakePosition[1]] = '.';

            moveSnake(command, snakePosition);
            if (!isInbound(matrix, snakePosition)) {
                break;
            }

            char currentSymbol = matrix[snakePosition[0]][snakePosition[1]];
            if (currentSymbol == 'B') {
                matrix[snakePosition[0]][snakePosition[1]] = '.';
                lairsPosition.removeIf(l -> l[0] == snakePosition[0] && l[1] == snakePosition[1]);
                snakePosition[0] = lairsPosition.get(0)[0];
                snakePosition[1] = lairsPosition.get(0)[1];
            } else if (currentSymbol == '*') {
                foods++;
            }

            matrix[snakePosition[0]][snakePosition[1]] = 'S';
        }
        if (foods < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foods);
        printMatrix(matrix);
    }

    private static boolean isInbound(char[][] matrix, int[] snakePosition) {
        return snakePosition[0] >= 0 && snakePosition[0] < matrix.length
                && snakePosition[1] >= 0 && snakePosition[1] < matrix.length;
    }

    private static void moveSnake(String command, int[] snakePosition) {
        switch (command) {
            case "up":
                snakePosition[0]--;
                break;
            case "down":
                snakePosition[0]++;
                break;
            case "left":
                snakePosition[1]--;
                break;
            case "right":
                snakePosition[1]++;
                break;
        }
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
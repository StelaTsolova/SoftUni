import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Python_2_26June2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[sizeMatrix][sizeMatrix];
        int[] pythonPosition = new int[2];
       // List<int[]> foodsPosition = new ArrayList<>();
        int foods = 0;
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = line.charAt(c);
                if (line.charAt(c) == 's') {
                    pythonPosition[0] = r;
                    pythonPosition[1] = c;
                } else if (line.charAt(c) == 'f') {
                  //  foodsPosition.add(new int[]{r, c});
                    foods++;
                }
            }
        }

        int length = 1;
        boolean isWon = true;
        for (String command : commands) {
            movePython(command, pythonPosition);
            checkIsInbound(matrix, pythonPosition);

            if (sizeMatrix > 0) {
                char currentSymbol = matrix[pythonPosition[0]][pythonPosition[1]];

                if (currentSymbol == 'e') {
                    isWon = false;
                    break;
                } else if (currentSymbol == 'f') {
                   // foodsPosition.removeIf(food -> food[0] == pythonPosition[0] && food[1] == pythonPosition[1]);
                    foods--;
                    length++;
                }
            }
        }

        if (foods == 0){
            System.out.printf("You win! Final python length is %d%n", length);
        } else if (!isWon) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", foods);
        }
    }

    private static void movePython(String command, int[] pythonPosition) {
        switch (command) {
            case "up":
                pythonPosition[0]--;
                break;
            case "down":
                pythonPosition[0]++;
                break;
            case "left":
                pythonPosition[1]--;
                break;
            case "right":
                pythonPosition[1]++;
                break;
        }
    }

    private static void checkIsInbound(char[][] matrix, int[] playerPosition) {
        if (playerPosition[1] >= matrix.length) {
            playerPosition[1] = 0;
        } else if (playerPosition[0] >= matrix.length) {
            playerPosition[0] = 0;
        } else if (playerPosition[1] < 0) {
            playerPosition[1] = matrix.length - 1;
        } else if (playerPosition[0] < 0) {
            playerPosition[0] = matrix.length - 1;
        }
    }
}
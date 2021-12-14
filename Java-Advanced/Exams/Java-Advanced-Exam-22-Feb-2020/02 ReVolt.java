import java.util.Scanner;

public class ReVolt_2_22Feb2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[sizeMatrix][sizeMatrix];
        int[] playerPosition = new int[2];
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine();
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = line.charAt(c);
                if (line.charAt(c) == 'f') {
                    playerPosition[0] = r;
                    playerPosition[1] = c;
                }
            }
        }

        boolean isWon = false;
        while (lines-- > 0) {
            String command = scanner.nextLine();
            int startRow = playerPosition[0];
            int startCol = playerPosition[1];
            matrix[playerPosition[0]][playerPosition[1]] = '-';
            movePlayer(command, playerPosition);
            checkIsInbound(matrix, playerPosition);

            char currentPosition = matrix[playerPosition[0]][playerPosition[1]];

            if (currentPosition == 'B') {
                movePlayer(command, playerPosition);
                checkIsInbound(matrix, playerPosition);
                currentPosition = matrix[playerPosition[0]][playerPosition[1]];
                if (currentPosition == 'F') {
                    matrix[playerPosition[0]][playerPosition[1]] = 'f';
                    isWon = true;
                    break;
                }
            } else if (currentPosition == 'T') {
                playerPosition[0] = startRow;
                playerPosition[1] = startCol;
            } else if (currentPosition == 'F') {
                matrix[playerPosition[0]][playerPosition[1]] = 'f';
                isWon = true;
                break;
            }
            matrix[playerPosition[0]][playerPosition[1]] = 'f';
        }
        if (isWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
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

    private static void movePlayer(String command, int[] playerPosition) {
        switch (command) {
            case "up":
                playerPosition[0]--;
                break;
            case "down":
                playerPosition[0]++;
                break;
            case "left":
                playerPosition[1]--;
                break;
            case "right":
                playerPosition[1]++;
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

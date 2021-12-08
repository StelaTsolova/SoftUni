import java.util.Scanner;

public class Bomb_2_20February2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        String[] commands = scanner.nextLine().split(",");

        int[] sapperPosition = new int[2];
        int bombs = 0;
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = line.charAt(c);
                if (line.charAt(c) == 's') {
                    sapperPosition[0] = r;
                    sapperPosition[1] = c;
                } else if (line.charAt(c) == 'B') {
                    bombs++;
                }
            }
        }

        boolean reachedTheEnd = false;
        for (String command : commands) {
            int currentRow = sapperPosition[0];
            int currentCol = sapperPosition[1];

            moveSapperPython(command, sapperPosition);

            if (!isInbound(matrix, sapperPosition)) {
                sapperPosition[0] = currentRow;
                sapperPosition[1] = currentCol;
                continue;
            }

            char currentSymbol = matrix[sapperPosition[0]][sapperPosition[1]];
            if (currentSymbol == 'B') {
                matrix[sapperPosition[0]][sapperPosition[1]] = '+';
                bombs--;
                System.out.println("You found a bomb!");
            } else if (currentSymbol == 'e') {
                reachedTheEnd = true;
                break;
            }
        }

        if (bombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (reachedTheEnd) {
            System.out.printf("END! %d bombs left on the field", bombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, sapperPosition[0], sapperPosition[1]);
        }
    }

    private static void moveSapperPython(String command, int[] sapperPosition) {
        switch (command) {
            case "up":
                sapperPosition[0]--;
                break;
            case "down":
                sapperPosition[0]++;
                break;
            case "left":
                sapperPosition[1]--;
                break;
            case "right":
                sapperPosition[1]++;
                break;
        }
    }

    private static boolean isInbound(char[][] matrix, int[] sapperPosition) {
        return sapperPosition[0] >= 0 && sapperPosition[0] < matrix.length
                && sapperPosition[1] >= 0 && sapperPosition[1] < matrix.length;
    }
}
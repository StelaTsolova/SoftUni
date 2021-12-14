import java.util.Scanner;

public class Bee_2_19August2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[sizeMatrix][sizeMatrix];
        int[] beePosition = new int[2];
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine();
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = line.charAt(c);
                if (line.charAt(c) == 'B') {
                    beePosition[0] = r;
                    beePosition[1] = c;
                }
            }
        }

        int polinationedFlowers = 0;
        boolean beeGotLost = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            matrix[beePosition[0]][beePosition[1]] = '.';
            moveBee(command, beePosition);
            if (!isInbound(matrix, beePosition)) {
                beeGotLost = true;
                break;
            }

            char currentSymbol = matrix[beePosition[0]][beePosition[1]];
            if (currentSymbol == 'O') {
                matrix[beePosition[0]][beePosition[1]] = '.';
                moveBee(command, beePosition);
                currentSymbol = matrix[beePosition[0]][beePosition[1]];
            }

            if (currentSymbol == 'f') {
                polinationedFlowers++;
            }

            matrix[beePosition[0]][beePosition[1]] = 'B';

            command = scanner.nextLine();
        }
        if (beeGotLost){
            System.out.println("The bee got lost!");
        }
        if (polinationedFlowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - polinationedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", polinationedFlowers);
        }

        printMatrix(matrix);
    }

    private static void moveBee(String command, int[] beePosition) {
        switch (command) {
            case "up":
                beePosition[0]--;
                break;
            case "down":
                beePosition[0]++;
                break;
            case "left":
                beePosition[1]--;
                break;
            case "right":
                beePosition[1]++;
                break;
        }
    }

    private static boolean isInbound(char[][] matrix, int[] beePosition) {
        return beePosition[0] >= 0 && beePosition[0] < matrix.length
                && beePosition[1] >= 0 && beePosition[1] < matrix.length;
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
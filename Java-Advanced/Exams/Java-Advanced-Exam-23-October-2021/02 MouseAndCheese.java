import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int[] mousePosition = new int[2];
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine();
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = line.charAt(c);
                if (line.charAt(c) == 'M') {
                    mousePosition[0] = r;
                    mousePosition[1] = c;
                }
            }
        }

        int cheeses = 0;
        boolean mouseGotLost = false;
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            matrix[mousePosition[0]][mousePosition[1]] = '-';
            moveMouse(command, mousePosition);
            if (!isInbound(matrix, mousePosition)) {
                mouseGotLost = true;
                break;
            }

            char currentSymbol = matrix[mousePosition[0]][mousePosition[1]];
            if (currentSymbol == 'B') {
                matrix[mousePosition[0]][mousePosition[1]] = '-';
                moveMouse(command, mousePosition);
                currentSymbol = matrix[mousePosition[0]][mousePosition[1]];
            }

            if (currentSymbol == 'c') {
                cheeses++;
            }

            matrix[mousePosition[0]][mousePosition[1]] = 'M';

            command = scanner.nextLine();
        }

        if (mouseGotLost){
            System.out.println("Where is the mouse?");
        }

        if (cheeses < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeses);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeses);
        }
        printMatrix(matrix);
    }

    private static void moveMouse(String command, int[] mousePosition) {
        switch (command) {
            case "up":
                mousePosition[0]--;
                break;
            case "down":
                mousePosition[0]++;
                break;
            case "left":
                mousePosition[1]--;
                break;
            case "right":
                mousePosition[1]++;
                break;
        }
    }

    private static boolean isInbound(char[][] matrix, int[] mousePosition) {
        return mousePosition[0] >= 0 && mousePosition[0] < matrix.length
                && mousePosition[1] >= 0 && mousePosition[1] < matrix.length;
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
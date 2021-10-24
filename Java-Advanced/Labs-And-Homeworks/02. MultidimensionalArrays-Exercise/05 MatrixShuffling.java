import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatrixShuffling_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeMatrix = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = sizeMatrix[0];
        int cols = sizeMatrix[1];

        List<List<String>> matrix = getMatrixOfList(scanner, rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            boolean commandIsValid = checkCommand(command, rows, cols);
            if (commandIsValid) {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                String temp = matrix.get(row1).get(col1);
                matrix.get(row1).set(col1, matrix.get(row2).get(col2));
                matrix.get(row2).set(col2, temp);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    public static List<List<String>> getMatrixOfList(Scanner scanner, int rows, int cols) {
        List<List<String>> matrix = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            matrix.add(row, new ArrayList<>());
            String[] currentArray = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(col, currentArray[col]);
            }
        }
        return matrix;
    }

    private static boolean checkCommand(String[] command, int rows, int cols) {
        if (command.length > 5) {
            return false;
        }
        if (!command[0].equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols) {
            return false;
        }

        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);
        return row2 >= 0 && row2 < rows && col2 >= 0 && col2 < cols;
    }

    private static void printMatrix(List<List<String>> matrix) {
        for (List<String> strings : matrix) {
            System.out.println(String.join(" ", strings));
        }
    }
}
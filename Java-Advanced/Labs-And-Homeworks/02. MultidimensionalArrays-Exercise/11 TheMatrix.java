import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = coordinates[0];
        int cols = coordinates[1];
        char[][] matrix = fillMatrix(scanner, rows, cols);

        char newSymbol = scanner.nextLine().charAt(0);
        int[] oldSymbolCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startRow = oldSymbolCoordinates[0];
        int startCol = oldSymbolCoordinates[1];

        char oldSymbol = matrix[startRow][startCol];

        changeMatrix(matrix, startRow, startCol, newSymbol, oldSymbol);
        printMatrix(matrix);
    }

    private static char[][] fillMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    public static void changeMatrix(char[][] matrix, int row, int col, char newSymbol, char oldSymbol) {
        if (isOutOfBounds(matrix, row, col)) {
            return;
        }
        if (matrix[row][col] != oldSymbol) {
            return;
        }

        matrix[row][col] = newSymbol;

        changeMatrix(matrix, row + 1, col, newSymbol, oldSymbol);
        changeMatrix(matrix, row - 1, col, newSymbol, oldSymbol);
        changeMatrix(matrix, row, col + 1, newSymbol, oldSymbol);
        changeMatrix(matrix, row, col - 1, newSymbol, oldSymbol);
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
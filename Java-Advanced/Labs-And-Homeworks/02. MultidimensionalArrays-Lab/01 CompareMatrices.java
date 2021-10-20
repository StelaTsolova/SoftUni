import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = getArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] firstMatrix = getMatrix(rows, cols, scanner);

        rowsAndCols = getArray(scanner);
        rows = rowsAndCols[0];
        cols = rowsAndCols[1];

        int[][] secondMatrix = getMatrix(rows, cols, scanner);

        boolean isEqual = checksMatricesEqual(firstMatrix, secondMatrix);

        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] getMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = getArray(scanner);
        }
        return matrix;
    }

    public static boolean checksMatricesEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        if (firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
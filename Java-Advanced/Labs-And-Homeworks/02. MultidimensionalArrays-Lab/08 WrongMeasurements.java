import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(rows, scanner);

        int[] cords = getArray(scanner);
        int wrongRow = cords[0];
        int wrongCol = cords[1];
        int wrongNumber = matrix[wrongRow][wrongCol];

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    int sum = getSum(matrix, row, col, wrongNumber);
                    newMatrix[row][col] = sum;
                } else {
                    newMatrix[row][col] = matrix[row][col];
                }
            }
        }
        printMatrix(newMatrix);
    }

    public static int[][] getMatrix (int rows, Scanner scanner){
        int[][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = getArray(scanner);
        }
        return matrix;
    }

    public static int[] getArray(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    public static int getSum (int[][] matrix, int row, int col, int wrongNumber){
        int sum = 0;
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongNumber) {
            sum += matrix[row - 1][col];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNumber) {
            sum += matrix[row + 1][col];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongNumber) {
            sum += matrix[row][col - 1];
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumber) {
            sum += matrix[row][col + 1];
        }
        return sum;
    }

    public static void printMatrix (int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
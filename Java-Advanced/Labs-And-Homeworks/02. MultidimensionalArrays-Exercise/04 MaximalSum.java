import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeMatrix = getArray(scanner);
        int rows = sizeMatrix[0];
        int cols = sizeMatrix[1];
        int[][] matrix = getMatrix(scanner, rows, cols);

        int maxSum = 0;
        int maxRow = 0;
        int maxCol = 0;

        int currentSum = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                currentSum += matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2];
                currentSum += matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2];
                currentSum += matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
                currentSum = 0;
            }
        }
        int[][] maxMatrix = new int[3][3];
        for (int row = 0; row < maxMatrix.length; row++, maxRow++) {
            for (int col = 0; col < maxMatrix[row].length; col++, maxCol++) {
                maxMatrix[row][col] = matrix[maxRow][maxCol];
            }
            maxCol -= 3;
        }

        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(maxMatrix);
    }

    public static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] getMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getArray(scanner);
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
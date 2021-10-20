import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix_5 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = getArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = getMatrix(rows, cols, scanner);
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        StringBuilder maxMatrix = new StringBuilder();
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    maxMatrix =new StringBuilder(String.format("%d %d%n%d %d", matrix[row][col], matrix[row][col + 1], matrix[row + 1][col], matrix[row + 1][col + 1]));
                }
            }
        }
        System.out.println(maxMatrix);
        System.out.println(maxSum);

    }

    public static int[] getArray (Scanner scanner){
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] getMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getArray(scanner);
        }
        return matrix;
    }
}
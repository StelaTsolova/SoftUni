import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(size, scanner);
        int primarySum = getPrimaryDiagonalSum(matrix);
        int secondarySum = getSecondaryDiagonalSum(matrix);
        int difference = Math.abs(primarySum - secondarySum);
        System.out.println(difference);
    }

    private static int[][] getMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int col = 0;
        for (int row = 0; row < matrix.length; row++, col++) {
            sum += matrix[row][col];
        }
        return sum;
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int col = matrix.length - 1;
        for (int row = 0; row < matrix.length && col >= 0; row++, col--) {
            sum += matrix[row][col];
        }
        return sum;
    }
}
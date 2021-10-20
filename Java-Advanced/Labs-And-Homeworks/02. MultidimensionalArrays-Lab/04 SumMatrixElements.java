import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_4 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int[] rowsAndCols = getArray(scanner);
         int rows = rowsAndCols[0];
         int cols = rowsAndCols[1];

         int[][] matrix = getMatrix(rows, cols, scanner);

         int sum = Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();

        System.out.printf("%d%n%d%n%d", rows, cols, sum);
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
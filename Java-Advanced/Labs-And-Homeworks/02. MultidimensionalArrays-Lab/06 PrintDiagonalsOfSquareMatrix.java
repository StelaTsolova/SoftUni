import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(size, scanner);

        printFirstDiagonal(matrix);
        printSecondDiagonal(matrix);
    }

    private static int[][] getMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static void printFirstDiagonal(int[][] matrix) {
        int col = 0;
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][col] + " ");
            col++;
        }
        System.out.println();
    }

    private static void printSecondDiagonal(int[][] matrix) {
        int col = 0;
        for (int row = matrix.length - 1; row >= 0 ; row--) {
            System.out.print(matrix[row][col] + " ");
            col++;
        }
    }
}
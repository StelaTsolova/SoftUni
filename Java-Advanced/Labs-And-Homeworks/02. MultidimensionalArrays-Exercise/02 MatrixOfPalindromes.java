import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeMatrix = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = sizeMatrix[0];
        int cols = sizeMatrix[1];

        String[][] matrix = getMatrix(rows, cols);
        printMatrix(matrix);
    }

    public static String[][] getMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        char startLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String letters = "" + startLetter + (char) (startLetter + col) + startLetter;
                matrix[row][col] = letters;
            }
            startLetter = (char) (startLetter + 1);
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
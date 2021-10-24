import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degrees = getDegrees(scanner);

        String input = scanner.nextLine();
        List<String> words = new ArrayList<>();
        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }

        int rows = words.size();
        int cols = getCols(words);

        char[][] matrix = getMatrixOfCharacter(rows, cols, words);
        while (degrees >= 360) {
            degrees %= 360;
        }

        char[][] result = matrix;
        if (degrees == 90) {
            result = rotateMatrixBy90Degrees(matrix);
        } else if (degrees == 180) {
            result = rotateMatrixBy90Degrees(matrix);
            result = rotateMatrixBy90Degrees(result);
        } else if (degrees == 270) {
            result = rotateMatrixBy90Degrees(matrix);
            result = rotateMatrixBy90Degrees(result);
            result = rotateMatrixBy90Degrees(result);
        }
        printMatrix(result);
    }

    public static int getDegrees(Scanner scanner) {
        String[] command = scanner.nextLine().split("[(|)]");
        return Integer.parseInt(command[1]);
    }

    public static int getCols(List<String> words) {
        int cols = 0;
        for (String word : words) {
            if (word.length() > cols) {
                cols = word.length();
            }
        }
        return cols;
    }

    public static char[][] getMatrixOfCharacter(int rows, int cols, List<String> words) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String word = words.get(row);
                if (col < word.length()) {
                    matrix[row][col] = word.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }

    public static char[][] rotateMatrixBy90Degrees(char[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;
        char[][] result = new char[rows][cols];
        for (int row1 = 0, col2 = 0; row1 < result.length; row1++, col2++) {
            for (int col1 = 0, row2 = matrix.length - 1; col1 < result[row1].length; col1++, row2--) {
                result[row1][col1] = matrix[row2][col2];
            }
        }
        return result;
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
import java.util.Scanner;

public class FillTheMatrix_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(", ");
        int sizeMatrix = Integer.parseInt(command[0]);
        String typePattern = command[1];

        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        if (typePattern.equals("A")) {
            matrix = fillByPatternA(sizeMatrix);
        } else if ((typePattern.equals("B"))) {
            matrix = fillByPatternB(sizeMatrix);
        }

        printMatrix(matrix);
    }

    public static int[][] fillByPatternA(int sizeMatrix) {
        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        int number = 1;
        for (int col = 0; col < sizeMatrix; col++) {
            for (int row = 0; row < sizeMatrix; row++) {
                matrix[row][col] = number++;
            }
        }
        return matrix;
    }

    public static int[][] fillByPatternB(int sizeMatrix) {
        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        int number = 1;
        for (int col = 0; col < sizeMatrix; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < sizeMatrix; row++) {
                    matrix[row][col] = number++;
                }
            } else {
                for (int row = sizeMatrix - 1; row >= 0; row--) {
                    matrix[row][col] = number++;
                }
            }

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
import java.util.Scanner;

public class IntersectionOfTwoMatrices_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = getMatrix(rows, cols, scanner);
        char[][] secondMatrix = getMatrix(rows, cols, scanner);

        char[][] outputMatrix = getOutputMatrix(rows, cols, scanner, firstMatrix, secondMatrix);

        printMatrix(outputMatrix);
    }

    private static char[][] getMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] array = scanner.nextLine().split("\\s+");
            for (int col = 0; col < array.length; col++) {
                matrix[row][col] = array[col].charAt(0);
            }
        }
        return matrix;
    }
    private static char[][] getOutputMatrix(int rows, int cols, Scanner scanner, char[][] firstMatrix, char[][] secondMatrix) {
        char[][] outputMatrix = new char[rows][cols];
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    outputMatrix[row][col] = firstMatrix[row][col];
                } else {
                    outputMatrix[row][col] = '*';
                }
            }
        }
        return outputMatrix;
    }

    public static void printMatrix(char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

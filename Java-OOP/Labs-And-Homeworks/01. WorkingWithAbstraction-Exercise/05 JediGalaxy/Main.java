package JediGalaxy_5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = getIntArray(scanner.nextLine());
        int[][] matrix = fillMatrix(rowsAndCols);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoGalaxy = getIntArray(command);
            int[] evilGalaxy = getIntArray(scanner.nextLine());

            devilDestroys(matrix, evilGalaxy);
            sum += ivoCollects(matrix, ivoGalaxy);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static void devilDestroys(int[][] matrix, int[] evilGalaxy) {
        int row = evilGalaxy[0];
        int col = evilGalaxy[1];

        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[0].length) {
                matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    private static long ivoCollects(int[][] matrix, int[] ivoGalaxy) {
        int row = ivoGalaxy[0];
        int col = ivoGalaxy[1];
        long sum = 0;

        while (row >= 0 && col < matrix[1].length) {
            if (row < matrix.length && col >= 0 && col < matrix[0].length) {
                sum += matrix[row][col];
            }
            col++;
            row--;
        }
        return sum;
    }

    private static int[][] fillMatrix(int[] rowsAndCols) {
        int row = rowsAndCols[0];
        int col = rowsAndCols[1];
        int[][] matrix = new int[row][col];
        int value = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[r][c] = value++;
            }
        }
        return matrix;
    }

    private static int[] getIntArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
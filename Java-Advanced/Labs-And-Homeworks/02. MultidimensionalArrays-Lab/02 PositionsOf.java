import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = getArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = getMatrix(rows, cols, scanner);

        int number = Integer.parseInt(scanner.nextLine());

        List<int[]> output = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    output.add(new int[]{row, col});
                }
            }
        }
        if (output.isEmpty()) {
            System.out.println("not found");
        } else {
            output.forEach(a -> System.out.println(a[0] + " " + a[1]));
        }

    }

    public static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] getMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getArray(scanner);
        }
        return matrix;
    }
}
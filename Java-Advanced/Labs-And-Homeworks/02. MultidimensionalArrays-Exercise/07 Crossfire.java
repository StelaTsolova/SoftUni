import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeMatrix = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = sizeMatrix[0];
        int cols = sizeMatrix[1];
        List<List<Integer>> matrix = getMatrixOfLists(rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] command = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = command[0];
            int col = command[1];
            int radius = command[2];

            destroysVertical(matrix, row, col, radius);
            destroysHorizontal(matrix, row, col, radius);

            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        printMatrixOfLists(matrix);
    }

    public static List<List<Integer>> getMatrixOfLists(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(row, new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
        return matrix;
    }

    private static void destroysVertical(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int r = row - radius; r <= row + radius; r++) {
            if (checkRange(matrix, r, col) && r != row) {
                matrix.get(r).remove(col);
            }
        }
    }

    private static void destroysHorizontal(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int c = col + radius; c >= col - radius; c--) {
            if (checkRange(matrix, row, c)) {
                matrix.get(row).remove(c);
            }
        }
    }

    private static boolean checkRange(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrixOfLists(List<List<Integer>> matrix) {
        for (List<Integer> list : matrix) {
            list.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
}
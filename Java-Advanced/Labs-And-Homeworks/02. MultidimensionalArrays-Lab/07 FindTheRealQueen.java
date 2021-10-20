import java.util.Scanner;

public class FindTheRealQueen_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = getCharMatrix(scanner);
        boolean end = false;
        boolean isQueen = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 'q') {
                    isQueen = checkQueen(matrix, row, col);
                }

                if (isQueen) {
                    System.out.println(row + " " + col);
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
        }
    }

    public static boolean checkQueen(char[][] matrix, int row, int col) {
            for (int i = col - 1; i >= 0; i--) {
                char currentSymbol = matrix[row][i];
                if (currentSymbol == 'q') {
                    return false;
                }
            }
            for (int i = col + 1; i < matrix[row].length; i++) {
                char currentSymbol = matrix[row][i];
                if (currentSymbol == 'q') {
                    return false;
                }
            }
            for (int i = row - 1; i >= 0; i--) {
                char currentSymbol = matrix[i][col];
                if (currentSymbol == 'q') {
                    return false;
                }
            }
            for (int i = row + 1; i < matrix.length; i++) {
                char currentSymbol = matrix[i][col];
                if (currentSymbol == 'q') {
                    return false;
                }
            }

            int currentRow = row - 1;
            for (int i = col - 1; i >= 0 && currentRow >= 0; i--, currentRow--) {
                char currentSymbol = matrix[currentRow][i];
                if (currentSymbol == 'q') {
                    return false;
                }
            }

            currentRow = row + 1;
            for (int i = col + 1; i < matrix[row].length && currentRow < matrix.length; i++, currentRow++) {
                char currentSymbol = matrix[currentRow][i];
                if (currentSymbol == 'q') {
                    return false;
                }
            }

            int currentCol = col + 1;
            for (int i = row - 1; i >= 0 && currentCol < matrix[row].length; i--, currentCol++) {
                char currentSymbol = matrix[i][currentCol];
                if (currentSymbol == 'q') {
                    return false;
                }
            }

            currentCol = col - 1;
            for (int i = row + 1; i < matrix.length && currentCol >= 0; i++, currentCol--) {
                char currentSymbol = matrix[i][currentCol];
                if (currentSymbol == 'q') {
                    return false;
                }
            }
        return true;
    }

    public static char[][] getCharMatrix(Scanner scanner) {
        char[][] matrix = new char[8][8];
        for (int row = 0; row < matrix.length; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int col = 0; col < arr.length; col++) {
                matrix[row][col] = arr[col].charAt(0);
            }
        }
        return matrix;
    }
}
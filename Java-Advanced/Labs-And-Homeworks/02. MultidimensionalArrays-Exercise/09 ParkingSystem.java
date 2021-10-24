import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeParking = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = sizeParking[0];
        int cols = sizeParking[1];
        boolean[][] parking = new boolean[rows][cols];

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int[] information = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entry = information[0];
            int row = information[1];
            int col = information[2];
            int counter = Math.abs(entry - row);
            if (rowIsFull(parking[row])) {
                System.out.printf("Row %d full%n", row);
            } else {
                if (!parking[row][col]) {
                    parking[row][col] = true;
                    counter += col + 1;
                } else {
                    int counterCol = 1;
                    while (true) {
                        if (col - counterCol > 0) {
                            if (!parking[row][col - counterCol]) {
                                parking[row][col - counterCol] = true;
                                counter += col + 1 - counterCol;
                                break;
                            }
                        }
                        if (col + counterCol < cols) {
                            if (!parking[row][col + counterCol]) {
                                parking[row][col + counterCol] = true;
                                counter += col + 1 + counterCol;
                                break;
                            }
                        }
                        counterCol++;
                    }
                }
                System.out.println(counter);
            }
            input = scanner.nextLine();
        }

    }

    private static boolean rowIsFull(boolean[] parking) {
        for (int index = 1; index < parking.length; index++) {
            if (!parking[index]) {
                return false;
            }
        }
        return true;
    }
}
package PointInRectangle_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = readIntArray(scanner);
        Point A = new Point(coordinates[0], coordinates[1]);
        Point B = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(A, B);

        int lines = Integer.parseInt(scanner.nextLine());
        while (lines-- > 0) {
            int[] pointCoordinates = readIntArray(scanner);
            Point point = new Point(pointCoordinates[0], pointCoordinates[1]);
            printResult(rectangle, point);
        }
    }

    public static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static void printResult(Rectangle rectangle, Point point) {
        System.out.println(rectangle.contains(point));
    }
}
import java.util.Scanner;
import java.util.function.Predicate;

public class RhombusOfStars_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String rhombusOfStars = createRhombusOfStars(size);
        print(rhombusOfStars);
    }

    private static String createRhombusOfStars(int size) {
        StringBuilder rhombusOfStars = new StringBuilder();

        rhombusOfStars.append(createRowsOfStars(1, size, +1, size));
        rhombusOfStars.append(createRowsOfStars(size - 1, 1, -1, size));

        return rhombusOfStars.toString();
    }

    public static String createRowsOfStars(int start, int end, int step, int size) {
        StringBuilder rowsOfStars = new StringBuilder();

        Predicate<Integer> loopCondition = iter -> {
            if (step > 0) {
                return iter <= end;
            }
            return iter >= end;
        };

        for (int r = start; loopCondition.test(r); r += step) {
            rowsOfStars.append(createLine(size - r, r)).append(System.lineSeparator());
        }

        return rowsOfStars.toString();
    }

    private static String createLine(int spaces, int stars) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            line.append(" ");
        }
        for (int i = 0; i < stars; i++) {
            line.append("* ");
        }

        return line.toString();
    }

    private static void print(String rhombusOfStars) {
        System.out.println(rhombusOfStars);
    }
}

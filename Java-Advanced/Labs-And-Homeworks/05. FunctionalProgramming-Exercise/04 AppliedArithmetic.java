import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        Function<int[], int[]> adds1 = a -> Arrays.stream(a).map(n -> n += 1).toArray();
        Function<int[], int[]> multiplies2 = a -> Arrays.stream(a).map(n -> n *= 2).toArray();
        Function<int[], int[]> subtracts1 = a -> Arrays.stream(a).map(n -> n -= 1).toArray();
        Consumer<int[]> print = a -> Arrays.stream(a).forEach(n -> System.out.print(n + " "));
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = adds1.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplies2.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtracts1.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
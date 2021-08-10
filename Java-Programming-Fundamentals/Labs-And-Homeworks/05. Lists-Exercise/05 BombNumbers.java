import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int[] bombNumAndPower = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumAndPower[0]) {
                int index = numbers.indexOf(numbers.get(i));
                numbers = detonatesRight(numbers, bombNumAndPower[1], index);
                numbers.remove(index);
                numbers = detonatesLeft(numbers, bombNumAndPower[1], index);
                i = 0;
            }
        }
        int sumOfNumbers = sumsNumbers(numbers);
        System.out.println(sumOfNumbers);
    }

    private static List<Integer> detonatesRight(List<Integer> numbers, int power, int index) {
        int counter = 0;
        while (counter != power) {
            if (index + 1 < numbers.size()) {
                numbers.remove(index + 1);
            }
            counter++;
        }
        return numbers;
    }

    private static List<Integer> detonatesLeft(List<Integer> numbers, int power, int index) {
        int counter = 1;
        for (int i = counter; i <= power; i++) {
            if (counter <= power && index - counter >= 0) {
                numbers.remove(index - counter);
            }
            counter++;
        }
        return numbers;
    }

    private static int sumsNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
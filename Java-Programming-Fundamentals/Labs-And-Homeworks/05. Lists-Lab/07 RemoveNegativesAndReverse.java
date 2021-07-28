import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        numbers = removeNegativeNumbers(numbers);
        printOutput(numbers);
    }

    private static List<Integer> removeNegativeNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0) {
                numbers.remove(numbers.get(i));
                i--;
            }
        }
        return numbers;
    }

    private static void printOutput(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
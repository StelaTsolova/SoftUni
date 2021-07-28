import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            int numOrIndex = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "Add":
                    numbers = addDigit(numbers,numOrIndex);
                    break;
                case "Remove":
                    numbers = removeDigit(numbers,numOrIndex);
                    break;
                case "RemoveAt":
                    numbers = removeAtDigit(numbers,numOrIndex);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    numbers = insertDigit(numbers,numOrIndex, index);
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> addDigit(List<Integer> numbers, int number) {
        numbers.add(number);
        return numbers;
    }

    private static List<Integer> removeDigit(List<Integer> numbers, int number) {
        numbers.remove(Integer.valueOf(number));
        return numbers;
    }

    private static List<Integer> removeAtDigit(List<Integer> numbers, int index) {
        numbers.remove(index);
        return numbers;
    }

    private static List<Integer> insertDigit(List<Integer> numbers, int number, int index) {
        numbers.add(index, number);
        return numbers;
    }
}
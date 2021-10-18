import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack_1 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(numbers::push);
        while (!numbers.isEmpty()){
            System.out.print(numbers.poll() + " ");
        }
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Numbers_3_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .sorted().collect(Collectors.toList());
        Collections.reverse(numbers);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double averageNum = sum / (numbers.size() * 1.0);
        List<Integer> output = new ArrayList<>();
        for (int number : numbers) {
            if (output.size() == 5) {
                break;
            } else {
                if (number > averageNum) {
                    output.add(number);
                } else {
                    break;
                }
            }
        }
        if (output.isEmpty()) {
            System.out.println("No");
        } else {
            output.sort(Comparator.reverseOrder());
            System.out.println(output.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
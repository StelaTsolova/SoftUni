import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_3_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        boolean isEmpty = false;
        int counter = 0;
        while (!input.equals("end")) {
            counter++;
            int[] indexes = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int startIndex = indexes[0];
            int endIndex = indexes[1];
            if (startIndex < 0 || startIndex > elements.size() - 1 || endIndex > elements.size() - 1 || endIndex < 0 || startIndex == endIndex) {
                System.out.println("Invalid input! Adding additional elements to the board");
                int putIndex = elements.size() / 2;
                elements.add(putIndex, String.format("-%da", counter));
                elements.add(putIndex, String.format("-%da", counter));
            } else {
                String firstElement = elements.get(startIndex);
                String secondElement = elements.get(endIndex);
                if (firstElement.equals(secondElement)) {
                    elements.remove(firstElement);
                    elements.remove(firstElement);
                    System.out.printf("Congrats! You have found matching elements - %s!%n", firstElement);
                } else {
                    System.out.println("Try again!");
                }
                if (elements.isEmpty()) {
                    isEmpty = true;
                    break;
                }
            }
            input = scanner.nextLine();
        }
        if (isEmpty) {
            System.out.printf("You have won in %d turns!", counter);
        } else {
            System.out.println("Sorry you lose :(");
            elements.forEach(e -> System.out.print(e + " "));
        }
    }
}
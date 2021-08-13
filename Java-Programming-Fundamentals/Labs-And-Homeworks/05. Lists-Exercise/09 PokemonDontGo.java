import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sumRemovedElements = 0;
        while (!numbers.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement = 2147483647;
            if (index < 0) {
                removedElement = numbers.get(0);
                numbers.remove(0);
                numbers.add(0, numbers.get(numbers.size() - 1));
            } else if (index > numbers.size() - 1) {
                removedElement = numbers.get(numbers.size() - 1);
                numbers.remove(numbers.size() - 1);
                numbers.add(numbers.get(0));
            } else {
                removedElement = numbers.get(index);
                numbers.remove(index);
            }
            sumRemovedElements += removedElement;
            int indexNum = 0;
            for (int number:numbers){
                if (number <= removedElement){
                    numbers.set(indexNum, numbers.get(indexNum) + removedElement);
                } else {
                    numbers.set(indexNum, numbers.get(indexNum) - removedElement);
                }
                indexNum++;
            }
        }
        System.out.print(sumRemovedElements);
    }
}

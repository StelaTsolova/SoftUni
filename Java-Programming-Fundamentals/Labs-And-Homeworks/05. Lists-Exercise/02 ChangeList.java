import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("end")) {
            int element = Integer.parseInt(command[1]);
            if (command[0].equals("Delete")) {
                numbers.removeAll(Arrays.asList(element));
            } else if (command[0].equals("Insert")) {
                int position = Integer.parseInt(command[2]);
                numbers.add(position,element);
            }
            command = scanner.nextLine().split("\\s+");
        }
        System.out.print(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
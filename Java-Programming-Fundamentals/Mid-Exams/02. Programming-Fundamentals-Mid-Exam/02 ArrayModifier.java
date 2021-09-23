import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier_2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> elements = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "swap":
                    int indexs1 = Integer.parseInt(command[1]);
                    int indexs2 = Integer.parseInt(command[2]);
                    int firstElement = elements.get(indexs1);
                    elements.set(indexs1, elements.get(indexs2));
                    elements.set(indexs2, firstElement);
                    break;
                case "multiply":
                    int indexm1 = Integer.parseInt(command[1]);
                    int indexm2 = Integer.parseInt(command[2]);
                    int sum = elements.get(indexm1) * elements.get(indexm2);
                    elements.set(indexm1, sum);
                    break;
                case "decrease":
                    for (int i = 0; i < elements.size(); i++) {
                        int element = elements.get(i);
                        elements.set(i, --element);
                    }
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
        System.out.println(elements.toString().replaceAll( "[\\[\\]\\\\]", ""));
    }
}
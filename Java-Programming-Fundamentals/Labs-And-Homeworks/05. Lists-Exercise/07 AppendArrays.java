import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays_7 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         List<String> input = Arrays.stream(scanner.nextLine().split("[|]")).collect(Collectors.toList());
        Collections.reverse(input);
        String output = input.toString().replaceAll("[\\[\\],]", "");
        System.out.print(output.replaceAll("\\s+", " "));
    }
}
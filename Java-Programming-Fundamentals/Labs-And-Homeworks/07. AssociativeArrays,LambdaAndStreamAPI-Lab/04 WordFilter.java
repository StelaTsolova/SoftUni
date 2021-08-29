import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordFilter_4 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        words.stream().filter(e -> e.length() % 2 == 0).forEach(System.out::println);
    }
}
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVAT_4 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        Function<String, Double> mapWhitVat = d -> Double.parseDouble(d) * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", ")).map(mapWhitVat)
                .forEach(n -> System.out.printf("%.2f%n", n));
    }
}
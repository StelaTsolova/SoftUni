import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CountRealNumbers_1 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> counts = new TreeMap<>();
        for (Double number:numbers){
            if (!counts.containsKey(number)){
                counts.put(number, 1);
            } else {
                counts.put(number, counts.get(number) + 1);
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.println(decimalFormat.format(entry.getKey()) + " -> " + entry.getValue());
        }
    }
}
import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation_8 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int pairs = Integer.parseInt(scanner.nextLine());
        Map<String,Double> studentsInformation = new TreeMap<>();
         while (pairs-- > 0){
             String name = scanner.nextLine();
             double[] scores = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
           //double averageScore  = Arrays.stream(scores).average().orElse(0);
            // double sum  = Arrays.stream(scores).sum();
             double sum = 0;
             for (Double grade : scores) {
                 sum += grade;
             }
             double averageScore  = sum / scores.length;
             studentsInformation.put(name, averageScore);
         }
        DecimalFormat decimalFormat = new DecimalFormat("#.################");
        studentsInformation.forEach((k, v) -> System.out.printf("%s is graduated with %s%n", k, decimalFormat.format(v)));
    }
}
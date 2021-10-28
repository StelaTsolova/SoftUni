import java.util.*;

public class AverageStudentsGrades_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentRecords = new TreeMap<>();
        while (lines-- > 0) {
            String[] record = scanner.nextLine().split("\\s+");
            String name = record[0];
            double grade = Double.parseDouble(record[1]);
            studentRecords.putIfAbsent(name, new ArrayList<>());
            studentRecords.get(name).add(grade);
        }
        studentRecords.forEach((k, v) -> {
            System.out.print(k + " -> ");
            v.forEach(e -> System.out.printf("%.2f ", e));
            //double sum = v.stream().mapToDouble(n -> n).sum();
            double sum = 0;
            for (Double grade : v) {
                sum += grade;
            }
            System.out.printf("(avg: %.2f)%n", sum / v.size() );
        });
    }
}
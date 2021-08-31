import java.util.*;

public class StudentAcademy_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsAndGrade = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!studentsAndGrade.containsKey(name)) {
                studentsAndGrade.put(name, new ArrayList<>());
            }
            studentsAndGrade.get(name).add(grade);
        }
        Map<String, Double> studentsPrint = new LinkedHashMap<>();
        studentsAndGrade.entrySet().forEach(e -> {
            double sum = e.getValue().stream().mapToDouble(v -> v).sum();
            double averageGrade = sum / e.getValue().size();
            if (averageGrade >= 4.5) {
                studentsPrint.put(e.getKey(), averageGrade);
            }
        });
        studentsPrint.entrySet().stream().sorted((v1, v2) -> Double.compare(v2.getValue(), v1.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f%n",e.getKey(), e.getValue()));
    }
}
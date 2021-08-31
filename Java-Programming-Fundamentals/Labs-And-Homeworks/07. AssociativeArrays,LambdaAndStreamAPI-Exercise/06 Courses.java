import java.util.*;

public class Courses_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> students = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String course = input.split(" : ")[0];
            String name = input.split(" : ")[1];
            if (!students.containsKey(course)) {
                students.put(course, new ArrayList<>());
            }
            students.get(course).add(name);
            input = scanner.nextLine();
        }
        students.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().stream().sorted(String::compareTo).forEach(student -> System.out.println("-- " + student));
                });
    }
}
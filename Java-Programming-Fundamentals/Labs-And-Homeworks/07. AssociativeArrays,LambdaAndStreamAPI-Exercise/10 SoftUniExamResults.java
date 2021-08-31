import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> userPoints = new HashMap<>();
        Map<String, Integer> submissionsCount = new HashMap<>();
        while (!input.equals("exam finished")) {
            String[] command = input.split("-");
            String userName = command[0];
            if (command.length == 3) {
                String language = command[1];
                int points = Integer.parseInt(command[2]);
                userPoints.putIfAbsent(userName, points);
                submissionsCount.putIfAbsent(language, 0);
                if (userPoints.get(userName) < points) {
                    userPoints.put(userName, points);
                }
                submissionsCount.put(language, submissionsCount.get(language) + 1);
            } else {
                userPoints.remove(userName);
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        userPoints.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(u -> System.out.println(u.getKey() + " | " + u.getValue()));
        System.out.println("Submissions:");
        submissionsCount.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(language -> System.out.println(language.getKey() + " - " + language.getValue()));
    }
}
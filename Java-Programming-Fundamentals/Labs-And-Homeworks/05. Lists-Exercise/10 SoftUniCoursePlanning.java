import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("course start")) {
            String[] command = input.split(":");
            int index = -1;
            String lessonTitle = command[1];
            switch (command[0]) {
                case "Add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(command[2]);
                    if (!schedule.contains(lessonTitle) && (index >= 0 && index <= schedule.size() - 1)) {
                        schedule.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    schedule.remove(lessonTitle);
                    schedule.remove(lessonTitle + "-Exercise");
                    break;
                case "Swap":
                    String lessonTitle2 = command[2];
                    if (schedule.contains(lessonTitle) && schedule.contains(lessonTitle2)) {
                        index = schedule.indexOf(lessonTitle);
                        int index2 = schedule.indexOf(lessonTitle2);
                        schedule.set(index, lessonTitle2);
                        schedule.set(index2, lessonTitle);
                        if (schedule.contains(lessonTitle + "-Exercise") && schedule.contains(lessonTitle2 + "-Exercise")) {
                            schedule.set(index2 + 1, lessonTitle + "-Exercise");
                            schedule.set(index + 1, lessonTitle2 + "-Exercise");
                        } else if (schedule.contains(lessonTitle + "-Exercise")) {
                            schedule.remove(lessonTitle2 + "-Exercise");
                            schedule.add(index2 + 1, lessonTitle + "-Exercise");
                        } else if (schedule.contains(lessonTitle2 + "-Exercise")) {
                            schedule.remove(lessonTitle2 + "-Exercise");
                            schedule.add(index + 1, lessonTitle2 + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if (schedule.contains(lessonTitle) && !schedule.contains(lessonTitle + "-Exercise")) {
                        index = schedule.indexOf(lessonTitle);
                            schedule.add(index + 1, lessonTitle + "-Exercise");
                    } else if (!schedule.contains(lessonTitle)){
                        schedule.add(lessonTitle);
                        schedule.add(lessonTitle + "-Exercise");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        printOutput(schedule);
    }

    private static void printOutput(List<String> schedule) {
        int counter = 1;
        for (String title : schedule) {
            System.out.printf("%d.%s%n", counter, title);
            counter++;
        }
    }
}
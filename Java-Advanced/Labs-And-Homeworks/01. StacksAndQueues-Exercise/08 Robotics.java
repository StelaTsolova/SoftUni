import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robots = scanner.nextLine().split(";");

        String[] names = new String[robots.length];
        int[] time = new int[robots.length];
        for (int i = 0; i < robots.length; i++) {
            String[] robot = robots[i].split("-");
            names[i] = robot[0];
            time[i] = Integer.parseInt(robot[1]);
        }

        String startingTime = scanner.nextLine();
        int startingTimeInSeconds = getStartingTimeInSeconds(startingTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        int[] workingTime = new int[names.length];
        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startingTimeInSeconds++;
            decreasesWorkingTime(workingTime);
            boolean isTaken = false;
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] == 0) {
                    workingTime[i] = time[i];
                    String timeNow = getTimeNow(startingTimeInSeconds);
                    System.out.println(names[i] + " - " + currentProduct + timeNow);
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static int getStartingTimeInSeconds(String startingTime) {
        int[] time = Arrays.stream(startingTime.split(":")).mapToInt(Integer::parseInt).toArray();
        int hours = time[0];
        int minutes = time[1];
        int seconds = time[2];
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static void decreasesWorkingTime(int[] workingTime) {
        for (int i = 0; i < workingTime.length; i++) {
            if (workingTime[i] > 0) {
                workingTime[i]--;
            }
        }
    }

    private static String getTimeNow(int time) {
        int hours = (time / 3600) % 24;
        int minutes = time % 3600 / 60;
        int seconds = time % 60;
        return String.format(" [%02d:%02d:%02d]", hours, minutes, seconds);
    }
}
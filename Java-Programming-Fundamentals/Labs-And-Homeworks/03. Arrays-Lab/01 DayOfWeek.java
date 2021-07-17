import java.util.Scanner;

public class DayOfWeek_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numDay = Integer.parseInt(scanner.nextLine());
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        if (numDay >= 1 && numDay <= 7) {
            System.out.println(days[numDay - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}

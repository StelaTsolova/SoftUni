import java.util.Scanner;

public class TheatrePromotions_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String output = "";
        if (age >= 0 && age <= 18) {
            switch (day) {
                case "Weekday":
                    output = String.format("12$");
                    break;
                case "Weekend":
                    output = String.format("15$");
                    break;
                case "Holiday":
                    output = String.format("5$");
                    break;
            }
        } else if (age > 18 && age <= 64) {
            switch (day) {
                case "Weekday":
                    output = String.format("18$");
                    break;
                case "Weekend":
                    output = String.format("20$");
                    break;
                case "Holiday":
                    output = String.format("12$");
                    break;
            }
        } else if (age > 64 && age <= 122) {
            switch (day) {
                case "Weekday":
                    output = String.format("12$");
                    break;
                case "Weekend":
                    output = String.format("15$");
                    break;
                case "Holiday":
                    output = String.format("10$");
                    break;
            }
        } else {
            output = String.format("Error!");
        }
        System.out.println(output);
    }
}

import java.util.Scanner;

public class BackIn30Minutes_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int timeInMinutesAfter30Min = hour * 60 + minutes + 30;
        int newHour = timeInMinutesAfter30Min / 60;
        int newMinutes = timeInMinutesAfter30Min % 60;
        if (newHour == 24) {
            System.out.printf("0:%02d", newMinutes);
        } else {
            System.out.printf("%d:%02d", newHour, newMinutes);
        }
    }
}

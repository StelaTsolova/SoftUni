import java.util.Scanner;

public class Division_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int delitel = 0;
        if (num % 10 == 0) {
            delitel = 10;
        } else if (num % 7 == 0) {
            delitel = 7;
        } else if (num % 6 == 0) {
            delitel = 6;
        } else if (num % 3 == 0) {
            delitel = 3;
        } else if (num % 2 == 0) {
            delitel = 2;
        }
        if (delitel == 0) {
            System.out.println("Not divisible");
        } else {
            System.out.println(String.format("The number is divisible by %d", delitel));
        }
    }
}
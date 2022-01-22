package CustomException_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String name = scanner.nextLine();
            String email = scanner.nextLine();
            try {
                Student student = new Student(name, email);
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

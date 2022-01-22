package ValidPerson_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String firstName = scanner.nextLine();
            String lastName = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());

            try {
                Person person = new Person(firstName, lastName, age);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

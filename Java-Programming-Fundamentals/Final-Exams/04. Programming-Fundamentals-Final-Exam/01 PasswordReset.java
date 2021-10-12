import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordReset_1_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        char symbol = password.charAt(i);
                        newPassword.append(symbol);
                    }
                    password = newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    password.delete(index, index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = command[1];
                    String substitute = command[2];
                    if (password.toString().contains(substring)){
                        password = new StringBuilder(password.toString().replaceAll(substring, substitute));
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
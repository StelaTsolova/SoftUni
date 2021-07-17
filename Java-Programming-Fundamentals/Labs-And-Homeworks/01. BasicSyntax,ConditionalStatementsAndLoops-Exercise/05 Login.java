import java.util.Scanner;

public class Login_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = "";
        boolean isLoging = false;

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }
        for (int i = 1; i <= 4; i++) {
            String input = scanner.nextLine();
            if (input.equals(password)) {
                System.out.println(String.format("User %s logged in.", username));
                isLoging = true;
                break;
            } else if (i < 4) {
                System.out.println("Incorrect password. Try again.");
            }
        }
        if (!isLoging){
            System.out.println(String.format("User %s blocked!", username));
        }
    }
}
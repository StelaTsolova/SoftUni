import java.util.Scanner;

public class PasswordValidator_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        boolean isValidLength = checksLength(password);
        boolean isValidConsists = checksConsists(password);
        boolean have2Digit = checksCountDigit(password);
        if (!isValidLength){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isValidConsists){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!have2Digit){
            System.out.println("Password must have at least 2 digits");
        }
        if (isValidLength && isValidConsists && have2Digit){
            System.out.println("Password is valid");
        }
    }

    private static boolean checksLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean checksConsists(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (!(symbol >= 48 && symbol <= 57) && !(symbol >= 97 && symbol <= 122) && !(symbol >= 65 && symbol <= 90)){
                return false;
            }
        }
        return true;
    }

    private static boolean checksCountDigit(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (symbol >= 48 && symbol <= 57){
                counter++;
            }
        }
            return counter >= 2;
    }
}
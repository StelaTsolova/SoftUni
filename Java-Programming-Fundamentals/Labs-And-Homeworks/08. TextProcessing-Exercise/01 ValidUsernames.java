import java.util.Scanner;

public class ValidUsernames_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] userNames = scanner.nextLine().split(", ");
        for (String user : userNames) {
            if (isValidUsername(user)){
                System.out.println(user);
            }
        }
    }

    private static boolean isValidUsername(String user) {
        if (user.length() < 3 || user.length() > 16){
            return false;
        }
        for (char symbol : user.toCharArray()) {
            if (!Character.isAlphabetic(symbol) && !Character.isDigit(symbol) && symbol != '-' && symbol != '_')
              return false;
        }
        return true;
    }
}
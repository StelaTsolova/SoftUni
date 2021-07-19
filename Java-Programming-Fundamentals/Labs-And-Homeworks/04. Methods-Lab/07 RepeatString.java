import java.util.Scanner;

public class RepeatString_7 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String string = scanner.nextLine();
         int n = Integer.parseInt(scanner.nextLine());
         String output = repeatString(string, n);
        System.out.println(output);
    }

    private static String repeatString(String string, int n) {
        String output = string;
        for (int i = 1; i < n; i++) {
            output += string;
        }
        return output;
    }
}

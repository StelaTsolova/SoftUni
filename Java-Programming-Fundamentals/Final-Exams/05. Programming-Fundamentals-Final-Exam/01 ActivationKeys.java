import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys_1_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder key = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String[] command = input.split(">>>");
            switch (command[0]) {
                case "Contains":
                    String substring = command[1];
                    Pattern pattern = Pattern.compile(substring);
                    Matcher matcher = pattern.matcher(key);
                    if (matcher.find()) {
                        System.out.printf("%s contains %s%n", key, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(command[2]);
                    int endIndex = Integer.parseInt(command[3]);
                    String change = "";
                    if (command[1].equals("Upper")) {
                        change = key.substring(startIndex, endIndex).toUpperCase();
                    } else if (command[1].equals("Lower")) {
                        change = key.substring(startIndex, endIndex).toLowerCase();
                    }
                    key.replace(startIndex, endIndex, change);
                    System.out.println(key);
                    break;
                case "Slice":
                    int sIndex = Integer.parseInt(command[1]);
                    int eIndex = Integer.parseInt(command[2]);
                    key.delete(sIndex, eIndex);
                    System.out.println(key);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", key);
    }
}
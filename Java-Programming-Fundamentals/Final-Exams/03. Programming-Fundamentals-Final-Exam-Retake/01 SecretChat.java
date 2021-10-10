import java.util.Scanner;

public class SecretChat_1_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] command = input.split(":\\|:");
            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = command[1];
                    if (message.toString().contains(substring)){
                        int startIndex = message.indexOf(substring);
                        message.delete(startIndex, startIndex + substring.length());
                        StringBuilder reversedSubstring = new StringBuilder(substring);
                        reversedSubstring.reverse();
                        message.append(reversedSubstring);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String oldSubstring = command[1];
                    String replacement = command[2];
                    message = new StringBuilder (message.toString().replaceAll(oldSubstring, replacement));
                    System.out.println(message);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
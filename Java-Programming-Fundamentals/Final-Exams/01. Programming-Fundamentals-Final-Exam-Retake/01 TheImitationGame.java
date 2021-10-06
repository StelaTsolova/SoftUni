import java.util.Scanner;

public class TheImitationGame_1_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String[] command = input.split("\\|");
            switch (command[0]) {
                case "Move":
                    int numLetters = Integer.parseInt(command[1]);
                    String moveString = message.substring(0, numLetters);
                    message.delete(0, numLetters);
                    message.append(moveString);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[1]);
                    String value = command[2];
                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = command[1];
                    String replacement = command[2];
                  //  if (message.toString().contains(substring)) {
                        message = new StringBuilder(message.toString().replace(substring, replacement));
                    //}
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", message);
    }
}
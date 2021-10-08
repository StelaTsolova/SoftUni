import java.util.Scanner;

public class WorldTour_1_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder messages = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")){
            String[] command = input.split(":");
            switch (command[0]){
                case "Add Stop":
                    int index = Integer.parseInt(command[1]);
                    String string = command[2];
                    if (index >= 0 && index < messages.length()){
                        messages.insert(index, string);
                    }
                    System.out.println(messages);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (startIndex >= 0 && endIndex < messages.length()){
                        messages.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(messages);
                    break;
                case "Switch":
                    String oldString = command[1];
                    String newString = command[2];
                    if (messages.toString().contains(oldString)){
                        messages = new StringBuilder(messages.toString().replaceAll(oldString, newString));
                    }
                    System.out.println(messages);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", messages);
    }
}
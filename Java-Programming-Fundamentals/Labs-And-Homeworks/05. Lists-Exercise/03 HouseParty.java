import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int countCommands = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < countCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String name = command[0];
            if (command[2].equals("going!")){
                if (list.contains(name)){
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    list.add(name);
                }
            } else {
                if (list.contains(name)){
                    list.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        printOutput(list);
    }

    private static void printOutput(List<String> list) {
        for (String name:list){
            System.out.println(name);
        }
    }
}
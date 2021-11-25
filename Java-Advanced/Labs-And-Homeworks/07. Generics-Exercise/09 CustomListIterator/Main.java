package CustomListIterator_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Add":
                    String element = command[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = command[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = command[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.forEach(System.out::println);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
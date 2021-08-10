import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("End")) {
            switch (command[0]) {
                case "Add":
                    int numberAdd = Integer.parseInt(command[1]);
                    numbers.add(numberAdd);
                    break;
                case "Insert":
                    int numberInsert = Integer.parseInt(command[1]);
                    int indexInsert = Integer.parseInt(command[2]);
                    if (indexInsert >= 0 && indexInsert < numbers.size()){
                        numbers.add(indexInsert, numberInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexRemove = Integer.parseInt(command[1]);
                    if (indexRemove >= 0 && indexRemove < numbers.size()){
                    numbers.remove(indexRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(command[2]);
                    if (command[1].equals("left")) {
                        numbers = movesLeft(numbers, count);
                    } else if (command[1].equals("right")) {
                        numbers = movesRight(numbers, count);
                    }
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
        printOutput(numbers);
    }

    private static List<Integer> movesLeft(List<Integer> numbers, int count) {
        int counter = 0;
        while (counter < count) {
            numbers.add(numbers.get(0));
            numbers.remove(0);
            counter++;
        }
        return numbers;
    }

    private static List<Integer> movesRight(List<Integer> numbers, int count) {
        int counter = 0;
       while (counter < count) {
            numbers.add(0, numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
            counter++;
        }
        return numbers;
    }

    private static void printOutput(List<Integer> numbers) {
        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
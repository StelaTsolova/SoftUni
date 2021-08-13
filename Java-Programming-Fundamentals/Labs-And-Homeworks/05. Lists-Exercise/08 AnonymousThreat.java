import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream((scanner.nextLine().split("\\s+"))).collect(Collectors.toList());
        String numCharInInput = getNumCharInInput(input);
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("3:1")) {
            if ((command[0].equals("merge"))) {
                int startIndex = Integer.parseInt(command[1]);
                int endIndex = Integer.parseInt(command[2]);
                if (startIndex < 0 && endIndex >= input.size()) {
                    startIndex = 0;
                    endIndex = input.size() - 1;
                } else if (startIndex >= 0 && endIndex >= input.size()) {
                    endIndex = input.size() - 1;
                } else if (startIndex < 0 && endIndex < input.size()) {
                    startIndex = 0;
                }
                input = mergeElemens(input, startIndex, endIndex);
            } else if (command[0].equals("divide")) {
                int index = Integer.parseInt(command[1]);
                int partitions = Integer.parseInt(command[2]);
                if (partitions <= numCharInInput.length()) {
                    divideElement(partitions, input, index, input.get(index));
                }
            }
            command = scanner.nextLine().split("\\s+");
        }
        System.out.print(input.toString().replaceAll("[\\[\\],]", ""));
    }

    private static String getNumCharInInput(List<String> input) {
        String numCgarInInput = "";
        for (String item:input){
            numCgarInInput += item;
        }
        return numCgarInInput;
    }

    private static List<String> mergeElemens(List<String> input, int startIndex, int endIndex) {
        for (int f = 0; f < endIndex - startIndex; f++) {
            input.set(startIndex, input.get(startIndex) + input.get(startIndex + 1));
            input.remove(startIndex + 1);
        }
        return input;
    }

    private static void divideElement( int partitions, List<String> input, int index, String element) {
        List<String> currentList = new ArrayList<>();
        int numSymbol = element.length() / partitions;
        int counter = 0;
        char symbol = ' ';
        String currentElement = "";
        if (element.length() % partitions == 0) {
            for (int i = 0; i < partitions; i++) {
                currentElement = "";
                for (int k = 0; k < numSymbol; k++) {
                    symbol = element.charAt(counter);
                    currentElement += symbol;
                    counter++;
                }
                currentList.add(currentElement);
            }
        } else {
            for (int i = 0; i < partitions; i++) {
                if (i == partitions - 1) {
                    currentElement = "";
                    for (int k = 0; k < numSymbol; k++) {
                        symbol = element.charAt(counter);
                        currentElement += symbol;
                        counter++;
                    }
                    currentList.add(currentElement);

                } else {
                    currentElement = "";
                    for (int k = 0; k <numSymbol; k++) {
                        symbol = element.charAt(counter);
                        currentElement += symbol;
                        counter++;
                    }
                    currentList.add(currentElement);
                }
            }
        }
        input.remove(index);
        input.addAll(index, currentList);
    }
}

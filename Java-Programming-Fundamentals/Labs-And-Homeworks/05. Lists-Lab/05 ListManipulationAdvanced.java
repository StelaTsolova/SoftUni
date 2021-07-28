import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Contains":
                    int searchDigit = Integer.parseInt(command[1]);
                    boolean isMeets = numbers.contains(searchDigit);
                            //chekMeetsCondition(numbers, command[1]);
                    printOutput(isMeets);
                    break;
                case "Print":
                    printAllNumber(numbers, command[1]);
                    break;
                case "Get":
                    printSumOfNumbers(numbers);
                    break;
                case "Filter":
                    printFulfillCondition(numbers, command[1], command[2]);
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
    }

//    private static boolean chekMeetsCondition(List<Integer> numbers, String condition) {
//        boolean isMeets = false;
//        int searchDigit = Integer.parseInt(condition);
//        for (int number : numbers) {
//            if (number == searchDigit) {
//                isMeets = true;
//                break;
//            }
//        }
//        return isMeets;
//    }

    private static void printOutput(boolean isMeets) {
        if (isMeets) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    private static void printAllNumber(List<Integer> numbers, String typeDigit) {
        if (typeDigit.equals("even")) {
            for (int number : numbers) {
                if (number % 2 == 0) {
                    System.out.print(number + " ");
                }
            }
        } else if (typeDigit.equals("odd")) {
            for (int number : numbers) {
                if (number % 2 != 0) {
                    System.out.print(number + " ");
                }
            }
        }
        System.out.println();
    }

    private static void printSumOfNumbers(List<Integer> numbers) {
        int sum = calculatesSum(numbers);
        System.out.println(sum);
    }

    private static int calculatesSum(List<Integer> numbers) {
        int sum = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    private static void printFulfillCondition(List<Integer> numbers, String sign, String condition) {
        int digit = Integer.parseInt(condition);
        if (sign.equals("<")) {
            for (int number : numbers) {
                if (number < digit) {
                    System.out.print(number + " ");
                }
            }
        } else if (sign.equals(">")) {
            for (int number : numbers) {
                if (number > digit) {
                    System.out.print(number + " ");
                }
            }
        } else if (sign.equals(">=")) {
            for (int number : numbers) {
                if (number >= digit) {
                    System.out.print(number + " ");
                }
            }
        } else if (sign.equals("<=")) {
            for (int number : numbers) {
                if (number <= digit) {
                    System.out.print(number + " ");
                }
            }
        }
        System.out.println();
    }
}
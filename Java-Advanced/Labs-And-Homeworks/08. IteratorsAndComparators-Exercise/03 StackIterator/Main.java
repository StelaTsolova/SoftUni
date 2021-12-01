package StackIterator_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String[] input = scanner.nextLine().split("[, ]+");
        while (!input[0].equals("END")) {
            if (input[0].equals("Push")) {
                int[] date = Arrays.stream(input).skip(1).mapToInt(Integer::parseInt).toArray();
                Arrays.stream(date).forEach(stack::push);
            } else if (input[0].equals("Pop")) {
                if (stack.getTop() != null) {
                    stack.pop();
                } else {
                    System.out.println("No elements");
                }
            }
            input = scanner.nextLine().split("[, ]+");
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
package Froggy_4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> numbers = Arrays.stream(input.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        Lake<Integer> lake = new Lake<>(numbers);

        int size = numbers.size();
        for (int lakee : lake) {
            System.out.print(lakee);
            if (--size != 0){
                System.out.print(", ");
            }
        }
    }
}

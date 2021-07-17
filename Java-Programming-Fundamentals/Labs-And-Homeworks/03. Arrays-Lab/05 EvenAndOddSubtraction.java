import java.util.Scanner;

public class EvenAndOddSubtraction_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        for (int num : numbers){
            if (num % 2 == 0) evenSum += num;
            else oddSum += num;
        }
        System.out.println(evenSum - oddSum);
    }
}

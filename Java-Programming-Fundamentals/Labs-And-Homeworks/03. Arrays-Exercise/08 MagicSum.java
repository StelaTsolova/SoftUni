import java.util.Scanner;

public class MagicSum_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == number) {
                    System.out.print(array[i] + " " + array[j]);
                    System.out.println();
                }
            }
        }
    }
}
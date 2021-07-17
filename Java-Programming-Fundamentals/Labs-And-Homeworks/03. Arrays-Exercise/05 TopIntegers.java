import java.util.Scanner;

public class TopIntegers_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < array.length; i++) {
            boolean isBigger = true;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] <= array[j]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger){
                System.out.print(array[i] + " ");
            }
        }
    }
}

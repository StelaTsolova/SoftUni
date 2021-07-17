import java.util.Scanner;

public class EqualSums_6 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] input = scanner.nextLine().split(" ");
         int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        boolean isHave = false;
        int output = -1;
        for (int i = 0; i < array.length; i++) {
        int leftSum = 0;
        int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }
            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }
            if (leftSum == rightSum) {
                output = i;
                isHave = true;
                break;
            }
        }
        if (isHave){
            System.out.println(output);
        } else {
            System.out.println("no");
        }
    }
}

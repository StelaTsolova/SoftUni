import java.util.Scanner;

public class EqualArrays_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] oneInput = scanner.nextLine().split(" ");
        String[] twoInput = scanner.nextLine().split(" ");
        int[] oneArray = new int[oneInput.length];
        int[] twoArray = new int[oneInput.length];
        boolean isDifferent = false;
        int sum = 0;
        for (int i = 0; i < oneInput.length; i++) {
            oneArray[i] = Integer.parseInt(oneInput[i]);
            twoArray[i] = Integer.parseInt(twoInput[i]);
            if (oneArray[i] != twoArray[i]) {
                isDifferent = true;
                System.out.println(String.format("Arrays are not identical. Found difference at %d index.", i));
                break;
            }
            sum += oneArray[i];
        }
        if (!isDifferent){
            System.out.println(String.format("Arrays are identical. Sum: %d", sum));
        }
    }
}

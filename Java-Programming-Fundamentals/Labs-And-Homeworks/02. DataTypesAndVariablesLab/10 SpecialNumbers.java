import java.util.Scanner;

public class SpecialNumbers_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String num = Integer.toString(i);
            int sum = 0;
            for (int j = 0; j < num.length(); j++) {
                int symbol = Character.getNumericValue(num.charAt(j));
                sum += symbol;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.println(String.format("%d -> True", i));
            } else {
                System.out.println(String.format("%d -> False", i));
            }
        }
    }
}

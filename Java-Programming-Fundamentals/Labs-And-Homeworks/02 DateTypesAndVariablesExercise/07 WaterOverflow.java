import java.util.Scanner;

public class WaterOverflow_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int litersInTank = 0;
        for (int i = 0; i < n; i++) {
            int currentLiters = Integer.parseInt(scanner.nextLine());
            if (litersInTank + currentLiters > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                litersInTank += currentLiters;
            }
        }
        System.out.println(litersInTank);
    }
}

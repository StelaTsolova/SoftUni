import java.util.Scanner;

public class SpiceMustFlow_9 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int startingYield = Integer.parseInt(scanner.nextLine());
         int days = 0;
         int leaving = 0;
        while (startingYield >= 100){
             days += 1;
             leaving += startingYield - 26;
             startingYield -= 10;
         }
        if (leaving >= 26)
            leaving -= 26;
        System.out.println(String.format("%d%n%d", days, leaving));
    }
}

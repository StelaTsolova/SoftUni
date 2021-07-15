import java.util.Scanner;

public class PrintAndSum_4 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int startNum = Integer.parseInt(scanner.next());
         int finalNum = Integer.parseInt(scanner.next());
         int sum = 0;
        for (int i = startNum; i <= finalNum ; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println(String.format("%nSum: %d", sum));
    }
}
import java.util.Scanner;

public class NxNMatrix_7 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int n = Integer.parseInt(scanner.nextLine());
         printNXN (n);
    }

    private static void printNXN(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
import java.util.Scanner;

public class PrintingTriangle_3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int number = Integer.parseInt(scanner.nextLine());
         printTriangle(number);
    }

    private static void printTriangle(int number) {
         printFirstPart(number);
         printSecondPart(number);
    }

    private static void printFirstPart(int number) {
        for (int i = 1; i < number; i++) {
            printLine(i);
        }
    }

    private static void printSecondPart(int number) {
        for (int i = number; i >= 1; i--) {
            printLine(i);
        }
    }

    private static void printLine(int digit) {
        for (int i = 1; i <= digit; i++) {
        System.out.print(i + " ");
        }
        System.out.println();
    }
}
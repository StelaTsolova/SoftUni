import java.util.Scanner;

public class GreaterOfTwoValues_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstNum, secondNum));
                break;
            case "char":
                char firstSymbol = scanner.nextLine().charAt(0);
                char secondSymbol = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstSymbol, secondSymbol));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                System.out.println(getMax(firstString, secondString));
                break;
        }
    }

    private static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        } else
            return secondNum;
    }

    private static char getMax(char firstSymbol, char secondSymbol) {
        if (firstSymbol > secondSymbol) {
            return firstSymbol;
        } else
            return secondSymbol;
    }

    private static String getMax(String firstString, String secondString) {
        if (firstString.compareTo(secondString) >= 0) {
            return firstString;
        } else
            return secondString;
    }
}
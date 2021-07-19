import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        DecimalFormat output = new DecimalFormat("0.####");
        System.out.println(output.format(mathPower(number, power)));
    }

    private static double mathPower(double number, int power) {
        return Math.pow(number, power);
    }
}
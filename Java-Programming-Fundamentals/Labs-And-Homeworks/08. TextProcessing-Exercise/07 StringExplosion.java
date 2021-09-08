import java.util.Scanner;

public class StringExplosion_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                StringBuilder input = new StringBuilder(scanner.nextLine());
        int strength = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol == '>'){
                strength += Character.getNumericValue(input.charAt(i + 1));
            } else if (strength != 0){
                input.deleteCharAt(i);
                strength--;
                i--;
            }
        }
        System.out.println(input);
    }
}
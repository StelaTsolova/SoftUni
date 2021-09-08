import java.util.Scanner;

public class CharacterMultiplier_2 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] input = scanner.nextLine().split("\\s+");
         String firstArgument = input[0];
         String secondArgument = input[1];
         int sum = getSumArguments(firstArgument, secondArgument);
        System.out.println(sum);
    }

    private static int getSumArguments(String firstArgument, String secondArgument) {
        int sum = 0;
        if (firstArgument.length() == secondArgument.length()){
            for (int i = 0; i < firstArgument.length(); i++) {
                char firstSymbol = firstArgument.charAt(i);
                char secondSymbol = secondArgument.charAt(i);
                sum += firstSymbol * secondSymbol;
            }
        } else if (firstArgument.length() > secondArgument.length()){
            for (int i = 0; i < secondArgument.length(); i++) {
                char firstSymbol = firstArgument.charAt(i);
                char secondSymbol = secondArgument.charAt(i);
                sum += firstSymbol * secondSymbol;
            }
            for (int i = secondArgument.length(); i < firstArgument.length() ; i++) {
                sum += firstArgument.charAt(i);
            }
        } else {
            for (int i = 0; i < firstArgument.length(); i++) {
                char firstSymbol = firstArgument.charAt(i);
                char secondSymbol = secondArgument.charAt(i);
                sum += firstSymbol * secondSymbol;
            }
            for (int i = firstArgument.length(); i < secondArgument.length() ; i++) {
                sum += secondArgument.charAt(i);
            }
        }
        return sum;
    }
}
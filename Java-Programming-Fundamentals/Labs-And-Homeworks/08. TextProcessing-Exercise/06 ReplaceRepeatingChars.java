import java.util.Scanner;

public class ReplaceRepeatingChars_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        String replacedSentence = replacesSentence(sequence);
        System.out.println(replacedSentence);
    }

    private static String replacesSentence(String sequence) {
        StringBuilder replacedSentence = new StringBuilder();
        replacedSentence.append(sequence.charAt(0));
        for (int i = 0; i < sequence.length() - 1; i++) {
            char symbol1 = sequence.charAt(i);
            char symbol2 = sequence.charAt(i + 1);
            if (symbol1 != symbol2) {
                replacedSentence.append(symbol2);
            }
        }
        return replacedSentence.toString();
    }
}
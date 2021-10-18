import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        ArrayDeque<Character> parentheses = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < sequence.length(); i++) {
            char bracket = sequence.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                parentheses.push(bracket);
            } else if ((bracket == ')' || bracket == '}' || bracket == ']') && !parentheses.isEmpty()){
                char lastBracket = parentheses.pop();
                if (!(lastBracket == '(' && bracket == ')') && !(lastBracket == '{' && bracket == '}') && !(lastBracket == '[' && bracket == ']')) {
                    isBalanced = false;
                    break;
                }
            } else {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced && parentheses.isEmpty()){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
import java.util.Scanner;

public class TextFilter_4 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] bannedWords = scanner.nextLine().split(", ");
         String text = scanner.nextLine();
         for (String bannedWord:bannedWords){
             if(text.contains(bannedWord)){
                 text = text.replace(bannedWord, "*".repeat(bannedWord.length()));
             }
         }
        System.out.println(text);
    }
}
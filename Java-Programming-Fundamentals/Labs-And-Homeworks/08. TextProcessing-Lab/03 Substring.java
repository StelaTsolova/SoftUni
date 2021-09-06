import java.util.Scanner;

public class Substring_3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String wordRemove = scanner.nextLine();
         String result = scanner.nextLine();
         while (result.contains(wordRemove)){
             int startIndex = result.indexOf(wordRemove);
             int endIndex = startIndex + wordRemove.length();
             result = result.substring(0, startIndex) + result.substring(endIndex);
         }
        System.out.println(result);
    }
}
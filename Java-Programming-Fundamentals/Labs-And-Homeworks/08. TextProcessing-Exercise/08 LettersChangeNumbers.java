import java.util.Scanner;

public class LettersChangeNumbers_8 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] input = scanner.nextLine().split("\\s+");
         double totalSum = 0.0;
         for (String sequence:input){
             char firstLatter = sequence.charAt(0);
             char secondLetter = sequence.charAt(sequence.length() - 1);
             double currentSum = Double.parseDouble(sequence.substring(1, sequence.length() - 1));
             if (Character.isUpperCase(firstLatter)){
                 currentSum /= firstLatter - 64;
             } else if (Character.isLowerCase(firstLatter)){
                 currentSum *= firstLatter - 96;
             }
             if (Character.isUpperCase(secondLetter)){
                 currentSum -= secondLetter - 64;
             } else if (Character.isLowerCase(secondLetter)){
                 currentSum += secondLetter - 96;
             }
             totalSum += currentSum;
         }
        System.out.printf("%.2f", totalSum);
    }
}
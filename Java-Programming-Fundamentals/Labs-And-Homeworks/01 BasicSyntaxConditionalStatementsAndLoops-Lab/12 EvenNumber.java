import java.util.Scanner;

public class EvenNumber_12 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         while (true){
             int input = Integer.parseInt(scanner.nextLine());
             if (input % 2 == 0){
                 System.out.println("The number is: " + Math.abs(input));
                 break;
             } else {
                 System.out.println("Please write an even number.");
             }
         }
    }
}

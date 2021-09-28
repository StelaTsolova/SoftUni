import java.util.Scanner;

public class NationalCourt_1_04 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int employee1 = Integer.parseInt(scanner.nextLine());
         int employee2 = Integer.parseInt(scanner.nextLine());
         int employee3 = Integer.parseInt(scanner.nextLine());
         int employees = employee1 + employee2 + employee3;
         int peopleCount = Integer.parseInt(scanner.nextLine());
         int counter = 0;
         int time = 0;
         while (!(peopleCount <= 0)){
             counter++;
             if (counter == 4){
                 time++;
                 counter = 1;
             }
             peopleCount -= employees;
             time++;
         }
        System.out.printf("Time needed: %dh.", time);
    }
}
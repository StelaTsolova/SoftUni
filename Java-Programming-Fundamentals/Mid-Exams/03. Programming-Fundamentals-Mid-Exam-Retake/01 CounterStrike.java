import java.util.Scanner;

public class CounterStrike_1_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int battlesWon = 0;
        boolean isWinner = true;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (distance <= energy) {
                energy -= distance;
                battlesWon++;
                if (battlesWon % 3 == 0){
                    energy += battlesWon;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesWon, energy);
                isWinner = false;
                break;
            }
            input = scanner.nextLine();
        }
        if (isWinner) {
            System.out.printf("Won battles: %d. Energy left: %d", battlesWon, energy);
        }
    }
}
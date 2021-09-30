import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline_2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        int health = 100;
        int bitcoin = 0;
        int counter = 0;
        boolean isKilled = false;
        for (String room : rooms) {
            counter++;
            String[] command = room.split("\\s+");
            if (command[0].equals("potion")) {
                int healed = Integer.parseInt(command[1]);
                if (health + healed >= 100) {
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    health = 100;
                } else {
                    health += healed;
                    System.out.printf("You healed for %d hp.%n", healed);
                }
                System.out.printf("Current health: %d hp.%n", health);
            } else if (command[0].equals("chest")) {
                int foundBitcoins = Integer.parseInt(command[1]);
                bitcoin += foundBitcoins;
                System.out.printf("You found %d bitcoins.%n", foundBitcoins);
            } else {
                int slain = Integer.parseInt(command[1]);
                health -= slain;
                if (health <= 0){
                    System.out.printf("You died! Killed by %s.%n", command[0]);
                    System.out.printf("Best room: %d", counter);
                    isKilled = true;
                    break;
                } else {
                    System.out.printf("You slayed %s.%n", command[0]);
                }
            }
        }
        if (!isKilled){
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoin, health);
        }
    }
}
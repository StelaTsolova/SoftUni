import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_5 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int numberCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingValidation = new LinkedHashMap<>();
        for (int i = 0; i < numberCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String username = command[1];
            switch (command[0]){
                case "register":
                    String licensePlateNumber = command[2];
                    if (parkingValidation.containsKey(username)){
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingValidation.get(username));
                    } else  {
                        parkingValidation.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!parkingValidation.containsKey(username)){
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        parkingValidation.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }
        }
        parkingValidation.forEach((k,v) -> System.out.println(k + " => " + v));
    }
}
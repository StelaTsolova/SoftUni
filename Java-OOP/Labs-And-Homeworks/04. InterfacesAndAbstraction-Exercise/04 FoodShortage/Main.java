package FoodShortage_4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyers = new LinkedHashMap<>();
        int lines = Integer.parseInt(scanner.nextLine());
        while (lines-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            if (information.length == 4) {
                String name = information[0];
                int age = Integer.parseInt(information[1]);
                String id = information[2];
                String birthDate = information[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                buyers.put(name, citizen);
            } else if (information.length == 3) {
                String name = information[0];
                int age = Integer.parseInt(information[1]);
                String group = information[2];
                Rebel rebel = new Rebel(name, age, group);
                buyers.put(name, rebel);
            }
        }

        String name = scanner.nextLine();
        while (!name.equals("End")) {
            if (buyers.containsKey(name)){
                buyers.get(name).buyFood();
            }
            name = scanner.nextLine();
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}

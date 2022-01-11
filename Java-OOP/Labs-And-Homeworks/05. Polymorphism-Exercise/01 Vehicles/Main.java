package Vehicles_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = createAndFillMap(scanner);

        int lines = Integer.parseInt(scanner.nextLine());
        while (lines-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            if (command[0].equals("Drive")) {
                double distance = Double.parseDouble(command[2]);
                System.out.println(vehicles.get(command[1]).drive(distance));
            } else {
                double liters = Double.parseDouble(command[2]);
                vehicles.get(command[1]).refuel(liters);
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Map<String, Vehicle> createAndFillMap(Scanner scanner) {
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] information = scanner.nextLine().split("\\s+");
        double fuel = Double.parseDouble(information[1]);
        double consumption = Double.parseDouble(information[2]);
        vehicles.put("Car", new Car(fuel, consumption));

        information = scanner.nextLine().split("\\s+");
        fuel = Double.parseDouble(information[1]);
        consumption = Double.parseDouble(information[2]);
        vehicles.put("Truck", new Truck(fuel, consumption));

        return vehicles;
    }
}
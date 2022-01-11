package VehiclesExtension_2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", createVehicle(scanner));
        vehicles.put("Truck", createVehicle(scanner));
        Bus bus = createBus(scanner);
        vehicles.put("Bus", bus);

        int lines = Integer.parseInt(scanner.nextLine());
        while (lines-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            if (command[0].equals("Drive") && command[1].equals("Bus")){
                double distance = Double.parseDouble(command[2]);
                    System.out.println(bus.driveWithPassengers(distance));
            } else if (command[0].equals("Drive") || command[0].equals("DriveEmpty")) {
                double distance = Double.parseDouble(command[2]);
                System.out.println(vehicles.get(command[1]).drive(distance));
            } else {
                double liters = Double.parseDouble(command[2]);
                try {
                    vehicles.get(command[1]).refuel(liters);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(Scanner scanner) {
        String[] information = scanner.nextLine().split("\\s+");
        double fuel = Double.parseDouble(information[1]);
        double consumption = Double.parseDouble(information[2]);
        int tankCapacity = Integer.parseInt(information[3]);
        try {
            switch (information[0]) {
                case "Car":
                    return new Car(fuel, consumption, tankCapacity);
                case "Truck":
                    return new Truck(fuel, consumption, tankCapacity);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static Bus createBus(Scanner scanner) {
        String[] information = scanner.nextLine().split("\\s+");
        double fuel = Double.parseDouble(information[1]);
        double consumption = Double.parseDouble(information[2]);
        int tankCapacity = Integer.parseInt(information[3]);
        try {
            return new Bus(fuel, consumption, tankCapacity);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}

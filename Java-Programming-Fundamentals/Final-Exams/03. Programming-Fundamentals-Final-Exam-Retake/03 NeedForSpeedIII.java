import java.util.*;

public class NeedForSpeedIII_3_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCars = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> cars = new TreeMap<>();
        for (int i = 0; i < numberCars; i++) {
            String[] carsInformation = scanner.nextLine().split("\\|");
            String typeCar = carsInformation[0];
            int mileage = Integer.parseInt(carsInformation[1]);
            int fuel = Integer.parseInt(carsInformation[2]);
            cars.put(typeCar, new ArrayList<>(Arrays.asList(mileage, fuel)));
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] command = input.split(" : ");
            String car = command[1];
            switch (command[0]) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);
                    if (cars.get(car).get(1) >= fuel) {
                        cars.get(car).set(1, cars.get(car).get(1) - fuel);
                        cars.get(car).set(0, cars.get(car).get(0) + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (cars.get(car).get(0) >= 100000){
                            cars.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    int fuelRefuel = Integer.parseInt(command[2]);
                    int newFuel = cars.get(car).get(1) + fuelRefuel;
                    if (newFuel > 75){
                        newFuel = 75;
                    }
                    System.out.printf("%s refueled with %d liters%n", car, newFuel - cars.get(car).get(1));
                    cars.get(car).set(1, newFuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(command[2]);
                    int newMileage = cars.get(car).get(0) - kilometers;
                    if (newMileage < 10000){
                        newMileage = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    cars.get(car).set(0, newMileage);
                    break;
            }
            input = scanner.nextLine();
        }
        cars.entrySet().stream().sorted((v1, v2) -> v2.getValue().get(0).compareTo(v1.getValue().get(0)))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue().get(0), e.getValue().get(1) ));
    }
}
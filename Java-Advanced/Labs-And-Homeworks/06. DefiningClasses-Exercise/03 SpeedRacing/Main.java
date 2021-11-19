package SpeedRacing_3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            String model = information[0];
            double fuelAmount = Double.parseDouble(information[1]);
            double fuelCostFor1km = Double.parseDouble(information[2]);
            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            cars.put(model, car);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            String carModel = command[1];
            int amountOfKm = Integer.parseInt(command[2]);
            Car currentCar = cars.get(carModel);
            if (checkCanReducesFuel(amountOfKm, currentCar.getFuelAmount(), currentCar.getFuelCostFor1km())) {
                currentCar.reducesFuel(amountOfKm);
                currentCar.increases(amountOfKm);
                cars.put(carModel, currentCar);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }
        cars.entrySet().forEach(e -> System.out.println(e.getValue().toString()));
    }

    private static boolean checkCanReducesFuel(int amountOfKm, double fuelAmount, double fuelCostFor1km) {
        return fuelAmount - (amountOfKm * fuelCostFor1km) >= 0;
    }
}
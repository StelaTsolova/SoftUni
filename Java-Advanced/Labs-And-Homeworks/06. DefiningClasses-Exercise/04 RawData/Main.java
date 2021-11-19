package RawData_4;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> cars = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            String model = information[0];
            int engineSpeed = Integer.parseInt(information[1]);
            int enginePower = Integer.parseInt(information[2]);
            int cargoWeight = Integer.parseInt(information[3]);
            String cargoType = information[4];
            double tire1Pressure = Double.parseDouble(information[5]);
            int tire1Age = Integer.parseInt(information[6]);
            double tire2Pressure = Double.parseDouble(information[7]);
            int tire2Age = Integer.parseInt(information[8]);
            double tire3Pressure = Double.parseDouble(information[9]);
            int tire3Age = Integer.parseInt(information[10]);
            double tire4Pressure = Double.parseDouble(information[11]);
            int tire4Age = Integer.parseInt(information[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire firstTire = new Tire(tire1Pressure, tire1Age);
            Tire secondTire = new Tire(tire2Pressure, tire2Age);
            Tire thirdTire = new Tire(tire3Pressure, tire3Age);
            Tire fourthTire = new Tire(tire4Pressure, tire4Age);

            Car car = new Car(model, engine, cargo, firstTire, secondTire, thirdTire, fourthTire);
            cars.putIfAbsent(cargoType, new ArrayList<>());
            cars.get(cargoType).add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")){
            cars.values().forEach(l -> {
                l.stream().filter(Car::checkPressure).forEach(m -> System.out.println(m.getModel()));
            });
        } else if (command.equals("flamable")){
            cars.values().forEach(l -> {
                l.stream().filter(Car::checkEnginePower).forEach(m -> System.out.println(m.getModel()));
            });
        }
    }
}
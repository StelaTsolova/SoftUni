package CarSalesman_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        while (n-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            String model = information[0];
            Engine engine = getEngine(information);
            engines.put(model, engine);
        }
        n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (n-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            Car car = getCar(information, engines);
            cars.add(car);
        }
        cars.forEach(c -> System.out.println(c.toString()));
    }

    public static Engine getEngine(String[] information) {
        Engine engine = null;
        String model = information[0];
        String power = information[1];
        if (information.length == 4) {
            String displacement = information[2];
            String efficiency = information[3];
            engine = new Engine(model, power, displacement, efficiency);
        } else if (information.length == 3) {
            String displacementOrEfficiency = information[2];
            engine = new Engine(model, power, displacementOrEfficiency);
        } else if (information.length == 2) {
            engine = new Engine(model, power);
        }
        return engine;
    }

    public static Car getCar(String[] information, Map<String, Engine> engines) {
        Car car = null;
        String model = information[0];
        String engineModel = information[1];
        Engine engine = engines.get(engineModel);
        if (information.length == 4) {
            String weight = information[2];
            String color = information[3];
            car = new Car(model, engine, weight, color);
        } else if (information.length == 3) {
            String weightOrColor = information[2];
            car = new Car(model, engine, weightOrColor);
        } else if (information.length == 2) {
            car = new Car(model, engine);
        }
        return car;
    }
}

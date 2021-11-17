package CarInfo_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (lines-- > 0) {
            String[] info = scanner.nextLine().split("\\s+");
            String brand = info[0];
            String model = info[1];
            int horsePower = Integer.parseInt(info[2]);
            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);
            cars.add(car);
        }
        cars.forEach(c -> System.out.println(c.toString()));
    }
}
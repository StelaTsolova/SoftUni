package CarConstructors_2;

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
            Car car;
            if (info.length > 1) {
                car = new Car(info[0], info[1], Integer.parseInt(info[2]));
            } else {
                car = new Car(info[0]);
            }
            cars.add(car);
        }
        cars.forEach(c -> System.out.println(c.toString()));
    }
}
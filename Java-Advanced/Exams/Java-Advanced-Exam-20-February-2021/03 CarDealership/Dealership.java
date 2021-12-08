package CarDealership_3_20February2021;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Dealership {
    private Collection<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>(capacity);
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return data.remove(car);
            }
        }
        return false;
    }

    public Car getLatestCar() {
       return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("The cars are in a car CarDealership_3_20February2021 %s:", this.name)).append(System.lineSeparator());
        for (Car car : data) {
            statistics.append(car).append(System.lineSeparator());
        }
        return statistics.toString().trim();
    }
}

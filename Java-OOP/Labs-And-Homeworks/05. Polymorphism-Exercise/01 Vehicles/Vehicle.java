package Vehicles_1;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Vehicle {
    private double fuel;
    private double consumption;

    protected Vehicle(double fuel, double consumption) {
        this.fuel = fuel;
        this.consumption = consumption;
    }

    public String drive(double distance) {
        double needFuel = distance * this.consumption;
        if (fuel > needFuel) {
            fuel -= needFuel;

            DecimalFormat formatter = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), formatter.format(distance));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }

    public void refuel(double liters) {
        this.fuel += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.fuel);
    }
}

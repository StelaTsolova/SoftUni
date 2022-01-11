package VehiclesExtension_2;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuel;
    private double consumption;
    private double tankCapacity;

    protected Vehicle(double fuel, double consumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuel(fuel);
        this.consumption = consumption;
    }

    public void setFuel(double fuel) {
        validateFuel(fuel);
        this.fuel = fuel;
    }

    private void validateFuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
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

    protected void addConsumption(double consumption) {
        this.consumption += consumption;
    }

    protected void reductionConsumption(double consumption) {
        this.consumption -= consumption;
    }

    public void refuel(double liters) {
        validateFuel(liters);
        setFuel(this.fuel + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.fuel);
    }
}

package SpeedRacing_3;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer and distance traveled.
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public void reducesFuel(int amountOfKm) {
        this.fuelAmount -= amountOfKm * this.fuelCostFor1km;
    }

    public void increases(int amountOfKm) {
        this.distanceTraveled += amountOfKm;
    }

    public String getModel() {
        return this.model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostFor1km() {
        return fuelCostFor1km;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTraveled);
    }
}

package VehiclesExtension_2;

public class Bus extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 1.4;

    public Bus(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption, tankCapacity);
    }

    public String driveWithPassengers(double distance) {
        super.addConsumption(AIR_CONDITIONER_CONSUMPTION);
        String output = super.drive(distance);
        super.reductionConsumption(AIR_CONDITIONER_CONSUMPTION);
        return output;
    }
}

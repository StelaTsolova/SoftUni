package VehiclesExtension_2;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;

    protected Car(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }
}

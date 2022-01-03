package CarShopExtend_2;

public class Seat extends CarImpl implements Sellable {
    public Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("Leon sells for %f", this.price);
    }
}
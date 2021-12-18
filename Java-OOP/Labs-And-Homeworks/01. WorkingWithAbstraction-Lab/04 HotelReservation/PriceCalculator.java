package HotelReservation_4;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double priceDay, int numberDays, Season season, Discount discount) {
        this.pricePerDay = priceDay;
        this.days = numberDays;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice() {
        double sum = (pricePerDay * season.getMultiplier()) * days;
        return sum - (sum * discount.getPercentage());
    }
}
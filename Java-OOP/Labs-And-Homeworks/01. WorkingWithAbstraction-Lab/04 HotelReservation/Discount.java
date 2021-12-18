package HotelReservation_4;

public enum Discount {
    NONE(0),
    SECOND_VISIT(0.1),
    VIP(0.2);

    private double percentage;

    Discount(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public static Discount parseDiscountType(String discountType) throws Exception {
        switch (discountType) {
            case "None":
                return NONE;
            case "SecondVisit":
                return SECOND_VISIT;
            case "VIP":
                return VIP;
            default:
                throw new Exception();
        }
    }
}
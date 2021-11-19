package CarSalesman_5;

public class Engine {
    //model, power, displacement and efficiency
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power, String displacementOrEfficiency) {
        this(model, power, "n/a", "n/a");
        if (Character.isDigit(displacementOrEfficiency.charAt(0))) {
            this.displacement = displacementOrEfficiency;
        } else {
            this.efficiency = displacementOrEfficiency;
        }
    }

    public Engine(String model, String power) {
        this(model, power, "n/a", "n/a");
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}

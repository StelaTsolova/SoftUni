package CarSalesman_5;

public class Car {
    //model, engine, weight and color
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String weightOrColor){
        this(model, engine, "n/a", "n/a");
            if (Character.isDigit(weightOrColor.charAt(0))){
                this.weight = weightOrColor;
            } else {
                this.color = weightOrColor;
            }
    }

    public Car(String model, Engine engine){
        this(model, engine, "n/a", "n/a");
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s",
                this.getModel(), this.getEngine().getModel(), this.getEngine().getPower(),
                this.getEngine().getDisplacement(), this.getEngine().getEfficiency(),
                this.getWeight(), this.getColor());
    }
}
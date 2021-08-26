package VehicleCatalogue_6;

public class Vehicles {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicles(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public void printVehicles(String type, String model, String color, int horsepower) {
        System.out.println(String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",type, model, color, horsepower));
    }

    public String getType() {
        return type.substring(0, 1).toUpperCase() + type.substring(1, type.length()).toLowerCase();
    }

    public void setType(String type) {
        this.type = type.substring(0, 1).toUpperCase() + type.substring(1, type.length()).toLowerCase();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
}


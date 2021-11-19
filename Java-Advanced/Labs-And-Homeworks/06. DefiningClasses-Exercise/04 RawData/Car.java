package RawData_4;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire firstTire;
    private Tire secondTire;
    private Tire thirdTire;
    private Tire fourthTire;

    public Car(String model, Engine engine, Cargo cargo, Tire firstTire, Tire secondTire, Tire thirdTire, Tire fourthTire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.firstTire = firstTire;
        this.secondTire = secondTire;
        this.thirdTire = thirdTire;
        this.fourthTire = fourthTire;
    }

    public String getModel() {
        return this.model;
    }

    public boolean checkPressure() {
        if (this.firstTire.getPressure() < 1) {
            return true;
        }
        if (this.secondTire.getPressure() < 1) {
            return true;
        }
        if (this.thirdTire.getPressure() < 1) {
            return true;
        }
        if (this.fourthTire.getPressure() < 1) {
            return true;
        }
        return false;
    }

    public boolean checkEnginePower() {
        return engine.getPower() > 250;
    }
}

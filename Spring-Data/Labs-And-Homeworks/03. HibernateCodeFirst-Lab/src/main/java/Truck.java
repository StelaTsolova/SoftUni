import javax.persistence.*;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle{

    @Column(name = "load_capacity")
    private double loadCapacity;

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}

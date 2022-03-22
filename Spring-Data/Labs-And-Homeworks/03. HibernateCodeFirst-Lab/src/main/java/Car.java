import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{

    private int seats;

    @OneToOne(optional = false)
    @JoinColumn(name = "number_id", referencedColumnName = "id")
    private PlateNumber number;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public PlateNumber getPlateNumber() {
        return number;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.number = plateNumber;
    }
}

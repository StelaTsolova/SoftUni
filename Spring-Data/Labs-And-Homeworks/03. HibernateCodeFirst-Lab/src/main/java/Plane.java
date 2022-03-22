import javax.persistence.*;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle {

    @Column(name = "passeger_capacity")
    private int passengerCapacity;

    @ManyToOne(optional = false)
    private Company company;

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

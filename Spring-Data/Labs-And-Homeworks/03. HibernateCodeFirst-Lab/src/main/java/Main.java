import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("code").createEntityManager();

        em.getTransaction().begin();;

        PlateNumber plateNumber = new PlateNumber();
        plateNumber.setNumber("4578");

        em.persist(plateNumber);

        Car car = new Car();
        car.setModel("a3");
        car.setPlateNumber(plateNumber);

        Vehicle truck = new Truck();
        truck.setModel("man");
        truck.setType("truck");

        Vehicle bike = new Bike();
        bike.setType("bike");

        Company company = new Company();
        company.setName("laser");
        em.persist(company);

        Plane plane = new Plane();
        plane.setFuelType("petrol");
        plane.setCompany(company);

        em.persist(car);
        em.persist(truck);
        em.persist(bike);
        em.persist(plane);

        em.getTransaction().commit();
    }
}

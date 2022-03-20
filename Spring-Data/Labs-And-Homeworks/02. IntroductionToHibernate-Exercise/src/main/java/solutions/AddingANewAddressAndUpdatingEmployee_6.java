package solutions;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddingANewAddressAndUpdatingEmployee_6 {
    public static void main(String[] args) throws IOException {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lastName = reader.readLine();

        em.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");

        em.persist(address);

        em.createQuery("UPDATE Employee e SET e.address = :new_address WHERE e.lastName = :l_name")
                .setParameter("new_address", address).setParameter("l_name", lastName).executeUpdate();

        em.getTransaction().commit();
    }
}

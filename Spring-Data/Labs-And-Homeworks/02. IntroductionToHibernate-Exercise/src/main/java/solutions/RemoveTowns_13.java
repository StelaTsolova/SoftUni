package solutions;

import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns_13 {
    public static void main(String[] args) throws IOException {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String townName = reader.readLine();

        Town town = em.createQuery("SELECT t FROM Town t where t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        List<Address> addresses = em.createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.id = :t_id", Address.class)
                .setParameter("t_id", town.getId())
                .getResultList();

        em.getTransaction().begin();
        addresses.forEach(em::remove);

        em.remove(town);

        em.getTransaction().commit();

        System.out.printf("%d address in %s deleted", addresses.size(), townName);
    }
}

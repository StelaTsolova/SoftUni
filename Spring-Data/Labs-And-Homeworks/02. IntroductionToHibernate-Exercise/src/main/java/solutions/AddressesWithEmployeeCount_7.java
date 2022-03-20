package solutions;
import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class AddressesWithEmployeeCount_7 {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        em.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10).getResultList().forEach(a -> System.out.printf("%s, %s - %d employees%n",
                        a.getText(),
                        a.getTown() == null
                                ? "Unknown"
                                : a.getTown().getName(),
                        a.getEmployees().size()));
    }
}

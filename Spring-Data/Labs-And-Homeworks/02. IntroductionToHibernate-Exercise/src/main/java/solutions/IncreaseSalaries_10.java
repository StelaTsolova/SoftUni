package solutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Set;

public class IncreaseSalaries_10 {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        Set<Integer> ids = Set.of(1, 2, 4, 11);
        em.getTransaction().begin();

        em.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN :ids")
                .setParameter("ids", ids)
                .executeUpdate();

        em.getTransaction().commit();

        em.createQuery("SELECT e FROM Employee e WHERE e.department.id IN :ids", Employee.class)
                .setParameter("ids", ids)
                .getResultStream().forEach(e -> System.out.printf("%s %s ($%.2f)%n",
                        e.getFirstName(), e.getLastName(), e.getSalary()));
    }
}

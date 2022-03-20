package solutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindEmployeesByFirstName_11 {
    public static void main(String[] args) throws IOException {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pattern = reader.readLine();

        em.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern + "%")
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
    }
}

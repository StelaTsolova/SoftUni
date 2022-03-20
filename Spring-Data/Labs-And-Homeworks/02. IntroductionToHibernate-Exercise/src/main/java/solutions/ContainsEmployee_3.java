package solutions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsEmployee_3 {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("softUni");
        EntityManager em = emf.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split("\\s+");
        String firstName = names[0];
        String lastName = names[1];

        long countEmployees = em.createQuery("SELECT COUNT(e) FROM Employee e " +
                        "WHERE e.firstName = :f_name AND e.lastName = :l_name", Long.class)
                .setParameter("f_name", firstName).setParameter("l_name", lastName).getSingleResult();

        System.out.println(countEmployees == 0 ? "No" : "Yes");
    }
}

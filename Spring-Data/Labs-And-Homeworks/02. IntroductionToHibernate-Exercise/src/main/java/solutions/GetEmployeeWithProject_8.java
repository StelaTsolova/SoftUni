package solutions;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class GetEmployeeWithProject_8 {
    public static void main(String[] args) throws IOException {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(reader.readLine());

        em.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class)
                .setParameter("id", id).getResultList()
                .forEach(e -> {
                    System.out.printf("%s %s - %s%n", e.getFirstName(), e.getLastName(), e.getJobTitle());
                    e.getProjects().stream().sorted(Comparator.comparing(Project::getName))
                            .forEach(p -> System.out.println("   " + p.getName()));
                });
    }
}

package solutions;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;

public class FindLatest10Projects_9 {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s");
        em.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC, p.name", Project.class)
                .setMaxResults(10).getResultStream().forEach(p -> {
                    System.out.println("Project name: " + p.getName());
                    System.out.println("   Project Description: " + p.getDescription());
                    System.out.println("   Project Start Date: " + p.getStartDate().format(formatter));
                    System.out.println("   Project End Date: " + p.getEndDate());
                });
    }
}
package solutions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ChangeCasing_2 {
    public static void main(String[] args) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("softUni");
       EntityManager em = emf.createEntityManager();

       em.getTransaction().begin();

       em.createQuery("UPDATE Town t SET t.name = upper(t.name) WHERE length(t.name) <= 5").executeUpdate();

       em.getTransaction().commit();
    }
}

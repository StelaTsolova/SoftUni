import entities.Student;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Configuration cfg = new Configuration();
//        cfg.configure();
//
//        SessionFactory sf = cfg.buildSessionFactory();
//        // so far - create database(if it wrote in hibernate.cfg.xml(row 18)) and tables
//
//        Session session = sf.openSession();
//        session.beginTransaction();
//
//        User user = new User();
//        user.setUsername("Maria");
//        user.setPassword("183");
//        session.save(user);
//
//        User user1 = session.get(User.class, 1L);
//        session.remove(user1);
//
//        List<User> users = session.createQuery("FROM User ", User.class).list();
//        users.forEach(System.out::println);

//        session.getTransaction().commit();
//        session.close();

        // two part - Student

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        Student student = new Student();
//        student.setName("Gosho");
//        student.setAverageScore(5.36);
//        em.persist(student);

        Student student1 = em.find(Student.class, 1L);
        em.remove(student1);

        em.getTransaction().commit();
        em.close();
    }
}

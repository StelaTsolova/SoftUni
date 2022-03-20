package solutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmployeesFromDepartment_5 {
    public static void main(String[] args) {
       EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

       em.createQuery("SELECT e FROM Employee e WHERE e.department.name = :d_name " +
                       "ORDER BY e.salary, e.id", Employee.class)
               .setParameter("d_name", "Research and Development").getResultStream()
               .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n", e.getFirstName(), e.getLastName(),
                       e.getDepartment().getName(), e.getSalary()));
    }
}

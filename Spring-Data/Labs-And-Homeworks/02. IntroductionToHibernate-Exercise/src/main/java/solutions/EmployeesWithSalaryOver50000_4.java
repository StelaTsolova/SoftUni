package solutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmployeesWithSalaryOver50000_4 {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        em.createQuery("SELECT e FROM Employee e WHERE e.salary > 50000", Employee.class)
                .getResultStream().map(Employee::getFirstName).forEach(System.out::println);
    }
}

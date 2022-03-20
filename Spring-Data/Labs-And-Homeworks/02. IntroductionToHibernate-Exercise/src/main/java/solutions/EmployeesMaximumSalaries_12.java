package solutions;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesMaximumSalaries_12 {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("softUni").createEntityManager();

        @SuppressWarnings("unchecked")
        List<Object[]> list = em.createNativeQuery("SELECT d.name, MAX(e.salary) AS `max_salary` FROM employees e " +
                        "JOIN departments d ON d.department_id = e.department_id  " +
                        "GROUP BY d.name HAVING `max_salary` NOT BETWEEN 30000 AND 70000")
                .getResultList();

        list.forEach(o -> System.out.printf("%s %.2f%n", o[0], Double.parseDouble(o[1].toString())));
    }
}

package com.example.exercisexmlprocessingtwo.repositories;

import com.example.exercisexmlprocessingtwo.models.dtos.orderedCustomers.CustomerOrderedDto;
import com.example.exercisexmlprocessingtwo.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT new com.example.exercisexmlprocessingtwo.models.dtos.orderedCustomers." +
            "CustomerOrderedDto(c.id, c.name, c.birthDate, c.youngDriver) FROM Customer c " +
            "ORDER BY c.birthDate, CASE WHEN c.youngDriver = FALSE then 1 else 2 end")
    List<CustomerOrderedDto> findAllOrderedByBirthDateThanIsYoungDriver();

    @Query("SELECT c FROM Customer c JOIN c.sales s JOIN s.car car JOIN car.parts p " +
            "WHERE c.sales IS NOT EMPTY " +
            "GROUP BY c ORDER BY SUM(p.price) DESC, COUNT (s) DESC")
    List<Customer> findAllBySalesIsNotNullOrderByTotalPriceThanCountSalesDesc();
}

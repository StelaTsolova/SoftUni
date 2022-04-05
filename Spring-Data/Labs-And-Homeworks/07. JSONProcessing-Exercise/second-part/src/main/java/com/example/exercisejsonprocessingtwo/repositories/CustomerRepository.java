package com.example.exercisejsonprocessingtwo.repositories;

import com.example.exercisejsonprocessingtwo.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c ORDER BY c.birthDate, " +
            "case when c.youngDriver = FALSE then 1 else 2 end")
    List<Customer> findAllCustomerOrderedByBirthdate();

//    @Query("SELECT c FROM Customer c JOIN Sale s ON c.id = s.customer.id " +
//            "JOIN Car c ON s.car.id = c.id " +
//            "JOIN OUT Part p ON c.sales  WHERE c.sales IS NOT EMPTY " +
//            "ORDER BY ")
//    (SELECT SUM (p.price ) FROM Part p JOIN Car c WHERE p.id IN s.car.parts)
    @Query("SELECT c FROM Customer c JOIN c.sales s JOIN s.car car JOIN car.parts p " +
            "WHERE c.sales IS NOT EMPTY " +
            "GROUP BY c ORDER BY SUM(p.price) DESC, COUNT (s) DESC")
//    @Query("SELECT c FROM Customer c JOIN c.sales s " +
//            "WHERE  c.sales IS NOT EMPTY " +
//            "ORDER BY (SELECT SUM (p.price) FROM Part p GROUP BY p.cars  )")
    List<Customer> findAllBySalesIsNotNullOrderByTotalPriceThanCountSalesDesc();
}

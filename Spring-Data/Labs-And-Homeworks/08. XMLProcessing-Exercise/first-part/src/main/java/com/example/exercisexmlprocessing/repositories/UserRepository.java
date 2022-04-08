package com.example.exercisexmlprocessing.repositories;

import com.example.exercisexmlprocessing.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE (SELECT COUNT (p) FROM Product p " +
            "WHERE p.seller.id = u.id AND p.buyer IS NOT NULL) > 0 " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findAllWithAtLeastOneSoldOrderByLastNameThanFirstName();

    @Query("SELECT u FROM User u WHERE (SELECT COUNT (p)  FROM Product p " +
            "WHERE p.seller.id = u.id AND p.buyer IS NOT NULL) > 0 " +
            "ORDER BY u.soldProducts.size DESC, u.lastName")
    List<User> findAllWithAtLeastOneSoldOrderByProductsCountDescThanLastName();
}

package com.example.exercisejsonprocessing.repositories;

import com.example.exercisejsonprocessing.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT COUNT (p) FROM Product p WHERE u.id = p.seller.id AND p.buyer IS NOT NULL) > 0" +
            "ORDER BY u.lastName, u.firstName")
    List<User> findAllWithMoreThanOneSoldProductOrderByLastNameThanFirstName();

    @Query("SELECT u FROM User u JOIN Product p ON u.id = p.seller.id " +
            "WHERE p.buyer IS NOT NULL GROUP BY u.id ORDER BY COUNT (u) DESC, u.lastName")
    List<User> findAllWithMoreThanOneSoldProductOrderByNumberProductsSoldThanLastName();

    User findUserByFirstNameAndLastName(String fistName, String lastName);
}

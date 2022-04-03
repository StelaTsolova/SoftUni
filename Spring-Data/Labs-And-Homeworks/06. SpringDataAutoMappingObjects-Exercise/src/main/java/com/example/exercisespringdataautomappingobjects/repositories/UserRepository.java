package com.example.exercisespringdataautomappingobjects.repositories;

import com.example.exercisespringdataautomappingobjects.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);

    User findUserById(Long id);
}

package com.example.exercisespringdataintrotwo.repositories;

import com.example.exercisespringdataintrotwo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {

    Set<User> getAllByEmailEndsWith(String provider);
}

package com.example.exercisespringdataautomappingobjects.repositories;

import com.example.exercisespringdataautomappingobjects.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    Game findGameById(Long id);

    Game findGameByTitle(String title);
}

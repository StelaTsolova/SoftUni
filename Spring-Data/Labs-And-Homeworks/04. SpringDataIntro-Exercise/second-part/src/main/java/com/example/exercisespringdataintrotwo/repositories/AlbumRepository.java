package com.example.exercisespringdataintrotwo.repositories;

import com.example.exercisespringdataintrotwo.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}

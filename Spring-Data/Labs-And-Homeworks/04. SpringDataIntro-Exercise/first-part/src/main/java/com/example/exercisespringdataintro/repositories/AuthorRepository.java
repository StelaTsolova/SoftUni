package com.example.exercisespringdataintro.repositories;

import com.example.exercisespringdataintro.models.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    Set<Author> getAllAuthorOrderByTheirBooksSizeDesc();
}

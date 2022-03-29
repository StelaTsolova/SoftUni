package com.example.exercisespringdataintro.repositories;

import com.example.exercisespringdataintro.models.entities.Author;
import com.example.exercisespringdataintro.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Set<Book> getAllByReleaseDateAfter(LocalDate releaseDate);

    Set<Book> getAllByReleaseDateBefore(LocalDate releaseDate);

    Set<Book> getAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String firstName, String lastName);
}

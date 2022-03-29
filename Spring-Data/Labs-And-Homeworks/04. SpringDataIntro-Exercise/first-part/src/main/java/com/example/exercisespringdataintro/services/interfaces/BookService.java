package com.example.exercisespringdataintro.services.interfaces;

import com.example.exercisespringdataintro.models.entities.Book;

import java.io.IOException;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    Set<Book> getBooksAfterYear(int year);

    Set<String> getAuthorNamesWithBooksWithReleaseDateBefore(int year);

    Set<String> getBookTitlesReleaseDatesCopiesByAuthorNameAndOrder(String firstName, String lastName);
}

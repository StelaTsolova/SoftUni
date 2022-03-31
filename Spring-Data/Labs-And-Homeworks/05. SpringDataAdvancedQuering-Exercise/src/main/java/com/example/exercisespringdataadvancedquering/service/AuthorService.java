package com.example.exercisespringdataadvancedquering.service;

import com.example.exercisespringdataadvancedquering.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<String> getAllAuthorNamesWhereFirstNamesEndingWithGivenString(String endsString);

    List<String> getAllAuthorNamesAndBookCopies();

    int getBookCountByAuthorNames(String firstName, String lastName);
}

package com.example.exercisespringdataintro.services.interfaces;

import com.example.exercisespringdataintro.models.entities.Author;

import java.io.IOException;
import java.util.Set;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    Set<String> getAuthorNamesAndTheirBookCountsOrderByBookCountsDesc();
}

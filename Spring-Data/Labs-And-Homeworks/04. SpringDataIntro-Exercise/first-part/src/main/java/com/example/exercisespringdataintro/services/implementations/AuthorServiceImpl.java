package com.example.exercisespringdataintro.services.implementations;

import com.example.exercisespringdataintro.models.entities.Author;
import com.example.exercisespringdataintro.repositories.AuthorRepository;
import com.example.exercisespringdataintro.services.interfaces.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_PATH)).forEach(this::saveAuthor);
    }

    private void saveAuthor(String row) {
        String[] fullName = row.split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        this.authorRepository.save(author);
    }

    @Override
    public Author getRandomAuthor() {
        Long id = ThreadLocalRandom.current().nextLong(1, this.authorRepository.count() + 1);

        return this.authorRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<String> getAuthorNamesAndTheirBookCountsOrderByBookCountsDesc() {
        return this.authorRepository.getAllAuthorOrderByTheirBooksSizeDesc()
                .stream().map(author -> String.format("%s %s %d", author.getFirstName(),
                        author.getLastName(), author.getBooks().size())).collect(Collectors.toSet());
    }
}

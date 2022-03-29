package com.example.exercisespringdataintro.services.implementations;

import com.example.exercisespringdataintro.models.entities.Author;
import com.example.exercisespringdataintro.models.entities.Book;
import com.example.exercisespringdataintro.models.entities.Category;
import com.example.exercisespringdataintro.models.enums.AgeRestriction;
import com.example.exercisespringdataintro.models.enums.EditionType;
import com.example.exercisespringdataintro.repositories.BookRepository;
import com.example.exercisespringdataintro.services.interfaces.AuthorService;
import com.example.exercisespringdataintro.services.interfaces.BookService;
import com.example.exercisespringdataintro.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String CATEGORIES_FILE_PATH = "src/main/resources/files/books.txt";

    private BookRepository bookRepository;
    private AuthorService authorService;
    private CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH)).forEach(this::saveBook);
    }

    private void saveBook(String row) {
        String[] information = row.split("\\s+");
        EditionType editionType = EditionType.values()[Integer.parseInt(information[0])];
        LocalDate releaseDate = LocalDate.parse(information[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(information[2]);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(information[3]));
        AgeRestriction ageRestriction =AgeRestriction.values()[Integer.parseInt(information[4])];
        String title = Arrays.stream(information).skip(5).collect(Collectors.joining(" "));

        Book book = new Book();
        book.setEditionType(editionType);
        book.setReleaseDate(releaseDate);
        book.setCopies(copies);
        book.setPrice(price);
        book.setAgeRestriction(ageRestriction);
        book.setTitle(title);

        Author author = this.authorService.getRandomAuthor();
        book.setAuthor(author);

        Set<Category> categories = this.categoryService.getRandomCategories();
        book.setCategories(categories);

        this.bookRepository.save(book);
    }

    public Set<Book> getBooksAfterYear(int year){
        return this.bookRepository.getAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public Set<String> getAuthorNamesWithBooksWithReleaseDateBefore(int year) {
        return this.bookRepository.getAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream().map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getBookTitlesReleaseDatesCopiesByAuthorNameAndOrder(String firstName, String lastName) {
        return this.bookRepository
                .getAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream().map(book -> String.format("%s %s %d", book.getTitle(), book.getReleaseDate(),
                        book.getCopies())).collect(Collectors.toSet());
    }
}

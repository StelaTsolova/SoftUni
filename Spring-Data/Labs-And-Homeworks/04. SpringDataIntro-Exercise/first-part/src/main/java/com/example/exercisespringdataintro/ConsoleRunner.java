package com.example.exercisespringdataintro;

import com.example.exercisespringdataintro.models.entities.Book;
import com.example.exercisespringdataintro.services.interfaces.AuthorService;
import com.example.exercisespringdataintro.services.interfaces.BookService;
import com.example.exercisespringdataintro.services.interfaces.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private AuthorService authorService;
    private CategoryService categoryService;
    private BookService bookService;

    public ConsoleRunner(AuthorService authorService, CategoryService categoryService,
                         BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        // seedDatabase();

        // printAllBookTitlesAfterYear(2000);

        // printAllAuthorNamesWithBooksWithReleaseDateBeforeYear(1990);

        //printAllAuthorNamesAndTheirBookCountsOrderByBookCountsDesc();

        printAllBookTitlesReleaseDatesCopiesByAuthorNameAndOrder("George", "Powell");
    }

    private void seedDatabase() throws IOException {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();
    }

    private void printAllBookTitlesAfterYear(int year) {
        this.bookService.getBooksAfterYear(year).stream()
                .map(Book::getTitle).forEach(System.out::println);
    }

    private void printAllAuthorNamesWithBooksWithReleaseDateBeforeYear(int year) {
        this.bookService.getAuthorNamesWithBooksWithReleaseDateBefore(year)
                .forEach(System.out::println);
    }

    private void printAllAuthorNamesAndTheirBookCountsOrderByBookCountsDesc() {
        this.authorService.getAuthorNamesAndTheirBookCountsOrderByBookCountsDesc()
                .forEach(System.out::println);
    }

    private void printAllBookTitlesReleaseDatesCopiesByAuthorNameAndOrder(String firstName, String lastName) {
        this.bookService.getBookTitlesReleaseDatesCopiesByAuthorNameAndOrder(firstName, lastName)
                .forEach(System.out::println);
    }
}

package com.example.exercisespringdataadvancedquering;

import com.example.exercisespringdataadvancedquering.model.entity.Book;
import com.example.exercisespringdataadvancedquering.service.AuthorService;
import com.example.exercisespringdataadvancedquering.service.BookService;
import com.example.exercisespringdataadvancedquering.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService,
                                 BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        // seedData();

        // printAllBooksAfterYear(2000);
        // printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        // printAllAuthorsAndNumberOfTheirBooks();
        // printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        // Exercises: Spring Data Advanced Quering
        Scanner scanner = new Scanner(System.in);

        // 1. Books Titles by Age Restriction
        printAllBookTitlesByGivenAgeRestriction(scanner);

        // 2. Golden Books
        printAllBookTitlesByEditionTypeGoldAndCopiesLessThan5000();

        // 3. Books by Price
        printAllBookTitlesAndPricesWherePriceLassThan5OrMoreThan40();

        // 4. Not Released Books
        printAllBookTitlesWhichNotReleasedInGivenYear(scanner);

        // 5. Books Released Before Date
        printAllBookTitlesEditionTypeAndPriceWithReleaseDateBeforeGivenDate(scanner);

        // 6. Authors Search
        printAllAuthorNamesByFirstNamesEndingWithGivenString(scanner);

        // 7. Books Search
        printAllBookTitlesWhichContainingGivenString(scanner);

        // 8. Book Titles Search
        printAllBookTitlesAndAuthorWhereAuthorLastNameStartingWithGivenString(scanner);

        // 9. Count Books
        printCountOfTitlesWhereTitleLengthLongerThanGivenNumber(scanner);

        // 10. Total Book Copies
        printAllAuthorNamesAndBookCopies();

        // 11. Reduced Book
        printInformationByGivenTitle(scanner);

        // 12. * Increase Book Copies
        printAddedBookCopies(scanner);

        // 13. * Remove Books
        printRemovedBookWhereCopiesLessThan(scanner);

        // 14. * Stored Procedure
        printAuthorsNameAndHisBookCount(scanner);
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

    private void printAllBookTitlesByGivenAgeRestriction(Scanner scanner) {
        this.bookService.findAllBookTitlesByGivenAgeRestriction(scanner.nextLine())
                .forEach(System.out::println);
    }

    private void printAllBookTitlesByEditionTypeGoldAndCopiesLessThan5000() {
        this.bookService.findAllBookTitlesByEditionTypeGoldAndCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void printAllBookTitlesAndPricesWherePriceLassThan5OrMoreThan40() {
        this.bookService.findAllBookTitlesAndPricesWherePriceLassThan5OrMoreThan40()
                .forEach(System.out::println);
    }

    private void printAllBookTitlesWhichNotReleasedInGivenYear(Scanner scanner) {
        int year = Integer.parseInt(scanner.nextLine());

        this.bookService.findAllBookTitlesWhichNotReleasedInGivenYear(year)
                .forEach(System.out::println);
    }

    private void printAllBookTitlesEditionTypeAndPriceWithReleaseDateBeforeGivenDate(Scanner scanner) {
        this.bookService
                .findAllBookTitlesEditionTypeAndPriceWithReleaseDateBeforeGivenDate(scanner.nextLine())
                .forEach(System.out::println);
    }

    private void printAllAuthorNamesByFirstNamesEndingWithGivenString(Scanner scanner) {
        this.authorService.getAllAuthorNamesWhereFirstNamesEndingWithGivenString(scanner.nextLine())
                .forEach(System.out::println);
    }

    private void printAllBookTitlesWhichContainingGivenString(Scanner scanner) {
        this.bookService.findAllBookTitlesWhichContainingGivenString(scanner.nextLine())
                .forEach(System.out::println);
    }

    private void printAllBookTitlesAndAuthorWhereAuthorLastNameStartingWithGivenString(Scanner scanner) {
        this.bookService
                .findAllBookTitlesAndAuthorWhereAuthorLastNameStartingWithGivenString(scanner.nextLine())
                .forEach(System.out::println);
    }

    private void printCountOfTitlesWhereTitleLengthLongerThanGivenNumber(Scanner scanner) {
        int length = Integer.parseInt(scanner.nextLine());

        int count = this.bookService.getCountOfTitlesWhereTitleLengthLongerThanGivenNumber(length);

        System.out.println(count);
    }

    private void printAllAuthorNamesAndBookCopies() {
        this.authorService.getAllAuthorNamesAndBookCopies().forEach(System.out::println);
    }

    private void printInformationByGivenTitle(Scanner scanner) {
        this.bookService.getInformationByGivenTitle(scanner.nextLine()).forEach(System.out::println);
    }

    private void printAddedBookCopies(Scanner scanner) {
        LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd MMM yyyy"));
        int count = Integer.parseInt(scanner.nextLine());

        int affectedRows = this.bookService
                .increasesCopiesWithGivenCountWhereReleasedAfterGivenDate(count, date);

        System.out.println(affectedRows * count);
    }

    private void printRemovedBookWhereCopiesLessThan(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());

        int affectedRows = this.bookService.removeBookByCopiesLessThanGivenNumber(number);

        System.out.println(affectedRows);
    }

    private void printAuthorsNameAndHisBookCount(Scanner scanner) {
        String[] fullName = scanner.nextLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        int countAuthorBooks = this.authorService.getBookCountByAuthorNames(firstName, lastName);

        System.out.printf("%s %s has written %d books%n", firstName, lastName, countAuthorBooks);
    }
}

package com.example.exercisespringdataadvancedquering.service.impl;

import com.example.exercisespringdataadvancedquering.model.entity.*;
import com.example.exercisespringdataadvancedquering.repository.BookRepository;
import com.example.exercisespringdataadvancedquering.service.AuthorService;
import com.example.exercisespringdataadvancedquering.service.BookService;
import com.example.exercisespringdataadvancedquering.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }

    @Override
    public List<String> findAllBookTitlesByGivenAgeRestriction(String input) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(input.toUpperCase());

        return this.bookRepository.findAllByAgeRestrictionEquals(ageRestriction)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesByEditionTypeGoldAndCopiesLessThan5000() {
        return this.bookRepository
                .findAllByEditionTypeEqualsAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesAndPricesWherePriceLassThan5OrMoreThan40() {
        return this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5L), BigDecimal.valueOf(40L))
                .stream().map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesWhichNotReleasedInGivenYear(int year) {
        LocalDate lowerDate = LocalDate.of(year, 1, 1);
        LocalDate upperDate = LocalDate.of(year, 12, 31);

        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(lowerDate, upperDate)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesEditionTypeAndPriceWithReleaseDateBeforeGivenDate(String input) {
        LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyy"));

        return this.bookRepository.findAllByReleaseDateBefore(date)
                .stream().map(book -> String.format("%s %s %.2f", book.getTitle(),
                        book.getEditionType().name(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesWhichContainingGivenString(String string) {
        return this.bookRepository.findAllByTitleContaining(string)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesAndAuthorWhereAuthorLastNameStartingWithGivenString(String startString) {
        return this.bookRepository.findAllByAuthor_LastNameStartingWith(startString)
                .stream().map(book -> String.format("%s (%s %s)", book.getTitle(),
                        book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int getCountOfTitlesWhereTitleLengthLongerThanGivenNumber(int length) {
        return this.bookRepository.countAllByTitleLengthLongerThan(length);
    }

    @Override
    public List<String> getInformationByGivenTitle(String title) {
        return this.bookRepository.findAllByTitle(title).stream()
                .map(book -> String.format("%s %s %s %.2f", book.getTitle(),
                        book.getEditionType().name(), book.getAgeRestriction().name(),
                        book.getPrice())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public int increasesCopiesWithGivenCountWhereReleasedAfterGivenDate(int count, LocalDate date) {
       return this.bookRepository.increasesCopiesWithGivenCountWhereReleasedAfterGivenDate(count, date);
    }

    @Override
    @Transactional
    public int removeBookByCopiesLessThanGivenNumber(int number) {
        return this.bookRepository.removeBookByCopiesLessThan(number);
    }
}

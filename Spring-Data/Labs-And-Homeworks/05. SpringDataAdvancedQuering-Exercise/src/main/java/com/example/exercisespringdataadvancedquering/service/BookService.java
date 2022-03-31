package com.example.exercisespringdataadvancedquering.service;

import com.example.exercisespringdataadvancedquering.model.entity.AgeRestriction;
import com.example.exercisespringdataadvancedquering.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBookTitlesByGivenAgeRestriction(String ageRestriction);

    List<String> findAllBookTitlesByEditionTypeGoldAndCopiesLessThan5000();

    List<String> findAllBookTitlesAndPricesWherePriceLassThan5OrMoreThan40();

    List<String> findAllBookTitlesWhichNotReleasedInGivenYear(int year);

    List<String> findAllBookTitlesEditionTypeAndPriceWithReleaseDateBeforeGivenDate(String date);

    List<String> findAllBookTitlesWhichContainingGivenString(String string);

    List<String> findAllBookTitlesAndAuthorWhereAuthorLastNameStartingWithGivenString(String startString);

    int getCountOfTitlesWhereTitleLengthLongerThanGivenNumber(int length);

    List<String> getInformationByGivenTitle(String title);

    int increasesCopiesWithGivenCountWhereReleasedAfterGivenDate(int count, LocalDate date);

    int removeBookByCopiesLessThanGivenNumber(int number);
}

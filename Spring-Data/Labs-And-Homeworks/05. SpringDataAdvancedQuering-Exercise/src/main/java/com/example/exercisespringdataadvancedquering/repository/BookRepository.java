package com.example.exercisespringdataadvancedquering.repository;

import com.example.exercisespringdataadvancedquering.model.entity.AgeRestriction;
import com.example.exercisespringdataadvancedquering.model.entity.Book;
import com.example.exercisespringdataadvancedquering.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String authorFirstName, String authorLastName);

    List<Book> findAllByAgeRestrictionEquals(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeEqualsAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerLimit, BigDecimal upperLimit);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lowerDate, LocalDate upperDate);

    List<Book> findAllByTitleContaining(String string);

    List<Book> findAllByAuthor_LastNameStartingWith(String startsString);

    @Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :length")
    int countAllByTitleLengthLongerThan(@Param(value = "length") int length);

    List<Book> findAllByTitle(String name);

    @Query("UPDATE Book b SET b.copies = b.copies + :count WHERE b.releaseDate > :date")
    @Modifying
    int increasesCopiesWithGivenCountWhereReleasedAfterGivenDate (int count, LocalDate date);

    @Modifying
    int removeBookByCopiesLessThan(int number);
}

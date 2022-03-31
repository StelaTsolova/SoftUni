package com.example.exercisespringdataadvancedquering.repository;

import com.example.exercisespringdataadvancedquering.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findAllByFirstNameEndingWith(String endsString);

    @Procedure("get_amount_author_books_by_authors_name")
    int getAmountOfAuthorBooksByAuthorNames(@Param("first_name") String firstName,
                                            @Param("last_name") String lastName);
}

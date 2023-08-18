package com.example.librarymanagementsystem.Repositories;

import com.example.librarymanagementsystem.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(value = "select * from author where age >=:enteredAge;",nativeQuery = true)
    List<Author> findAuthorsGreaterThanAge(Integer enteredAge);
}

package com.example.librarymanagementsystem.Repositories;

import com.example.librarymanagementsystem.Enums.Genre;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.ResponseDto.BookResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findBooksByGenre(Genre genre);

    List<Book> findBooksByIsAvailableFalse();
}

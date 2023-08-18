package com.example.librarymanagementsystem.Controllers;


import com.example.librarymanagementsystem.Enums.Genre;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.RequestDto.AddBookRequestDto;
import com.example.librarymanagementsystem.ResponseDto.AddBookResponseDto;
import com.example.librarymanagementsystem.ResponseDto.BookResponseDto;
import com.example.librarymanagementsystem.Services.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody AddBookRequestDto addBookRequestDto){

        try{

            String result = bookService.addBook(addBookRequestDto);
            return new ResponseEntity(result, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getByGenre")
    public ResponseEntity getBookListByGenre(@RequestParam("genre")Genre genre){
        List<BookResponseDto> responseDtoList = bookService.getBookListByGenre(genre);
        return new ResponseEntity(responseDtoList,HttpStatus.OK);
    }

}

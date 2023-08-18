package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Enums.Genre;
import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Repositories.AuthorRepository;
import com.example.librarymanagementsystem.Repositories.BookRepository;
import com.example.librarymanagementsystem.RequestDto.AddBookRequestDto;
import com.example.librarymanagementsystem.ResponseDto.BookResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public String addBook(AddBookRequestDto request)throws Exception{

        //Validation
        //AuthorId should be valid
        Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());

        if(!optionalAuthor.isPresent()){
            throw new Exception("Author Id Entered is Incorrect");
        }

        Author author = optionalAuthor.get();

        Book book = new Book(request.getTitle(),request.getIsAvailable(),request.getGenre(),request.getPublicationDate(),request.getPrice());

        //Entities will go inside the database and entities will only come out from Db

        //Got the book Object

        //Set the FK variables

        //Since it's a bidirectional : need to set both in child and parent class

        //Set the parent entity in child class
        book.setAuthor(author);

        //Setting in the parent
        List<Book> list = author.getBookList();
        list.add(book);
        author.setBookList(list);

        //I need to save them :-->

        //Save only the parent : child will get automatically saved
        authorRepository.save(author);
        return "Book has been successfully added and updated";
    }


    public List<BookResponseDto> getBookListByGenre(Genre genre){

        List<Book> bookList = bookRepository.findBooksByGenre(genre);
        List<BookResponseDto> responseList = new ArrayList<>();

        for(Book book : bookList){

            BookResponseDto bookResponseDto = new BookResponseDto(book.getTitle(),
                                                book.getIsAvailable(),book.getGenre(),
                                                book.getPublicationDate(),book.getPrice(),book.getAuthor().getName());

            responseList.add(bookResponseDto);
        }
        return responseList;
    }


}

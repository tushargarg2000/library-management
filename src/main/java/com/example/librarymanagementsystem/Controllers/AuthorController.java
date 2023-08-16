package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.RequestDto.UpdateNameAndPenNameRequest;
import com.example.librarymanagementsystem.Services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@Slf4j
public class AuthorController {

    @Autowired
    private AuthorService authorService;



    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){

        try{

            String result = authorService.addAuthor(author);
            return new ResponseEntity(result,HttpStatus.OK);

        }catch (Exception e){
            log.error("Author couldnt be added to the db {}",e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateNameAndPenName")
    public String updateAuthorNameAndPenName(@RequestBody UpdateNameAndPenNameRequest updateNameAndPenNameRequest){


        //@RequestBody Author author

        //1 endpoint has become long
        //Exposed in the URL itself

        try{
            String result = authorService.updateNameAndPenName(updateNameAndPenNameRequest);
            return result;

        }catch (Exception e){
            return "Author Id is invalid"+e.getMessage();
        }

    }

    @GetMapping("/getAuthor")
    public Author getAuthor(@RequestParam("authorId")Integer authorId){

        return authorService.getAuthorById(authorId);

    }



}

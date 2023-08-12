package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.Repositories.AuthorRepository;
import com.example.librarymanagementsystem.RequestDto.UpdateNameAndPenNameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String addAuthor(Author author)throws Exception{

        //Validation Checks
        if(author.getAuthorId()!=null){
            throw new Exception("Author Id should not be sent as a parameter");
        }

        authorRepository.save(author);
        return "Author has been successfully to the db";
    }

    public String updateNameAndPenName(UpdateNameAndPenNameRequest request)throws Exception{


        Optional<Author> authorOptional = authorRepository.findById(request.getAuthorId());

        if(!authorOptional.isPresent()){
            throw new Exception("AuthorId is Invalid");
        }

        Author author = authorOptional.get();

        author.setName(request.getNewName());
        author.setPenName(request.getNewPenName());

        authorRepository.save(author);

        return "Author Name and PenName has been updated";
    }


}

package com.example.librarymanagementsystem.Controllers;


import com.example.librarymanagementsystem.Models.LibraryCard;
import com.example.librarymanagementsystem.Services.LibraryCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@Slf4j
public class CardController {

    @Autowired
    private LibraryCardService cardService;


    @PostMapping("/create")
    public String addCard(@RequestBody LibraryCard card){

        return cardService.addCard(card);

    }

    @PutMapping("/issueToStudent")
    public ResponseEntity issueToStudent(@RequestParam("cardId")Integer cardId,@RequestParam("rollNo")Integer rollNo){

        try{

            String result =  cardService.associateToStudent(cardId,rollNo);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in associating card to student",e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

    }




}

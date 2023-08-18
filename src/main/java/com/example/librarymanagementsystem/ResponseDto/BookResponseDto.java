package com.example.librarymanagementsystem.ResponseDto;

import com.example.librarymanagementsystem.Enums.Genre;
import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.Models.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private String title;

    private Boolean isAvailable;

    private Genre genre;

    private Date publicationDate;

    private Integer price;

    private String authorName;


}

package com.example.librarymanagementsystem.Repositories;

import com.example.librarymanagementsystem.Enums.TransactionStatus;
import com.example.librarymanagementsystem.Enums.TransactionType;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Models.LibraryCard;
import com.example.librarymanagementsystem.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {


    List<Transaction> findTransactionsByBookAndLibraryCardAndTransactionStatusAndTransactionType(Book book, LibraryCard card, TransactionStatus transactionStatus, TransactionType transactionType);
}

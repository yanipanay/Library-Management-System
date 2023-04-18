package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.DTO.IssueBookRequestDTO;
import com.example.Library.Management.System.DTO.IssueBookResponseDTO;
import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Entity.Card;
import com.example.Library.Management.System.Entity.Transaction;
import com.example.Library.Management.System.Enums.Status;
import com.example.Library.Management.System.Enums.TransactionStatus;
import com.example.Library.Management.System.Exceptions.BookNotFoundException;
import com.example.Library.Management.System.Exceptions.CradNotFoundException;
import com.example.Library.Management.System.Repository.BookRepository;
import com.example.Library.Management.System.Repository.CardRepository;
import com.example.Library.Management.System.Repository.StudentRepository;
import com.example.Library.Management.System.Repository.TransactionRepository;
import com.example.Library.Management.System.Service.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;


    public IssueBookResponseDTO issue (IssueBookRequestDTO issueBookRequestDTO) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssue(true);

        Book book;
        Card card;
        try{
            book = bookRepository.findById(issueBookRequestDTO.getBookId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new BookNotFoundException("invalid book id");
        }
        try{
            card = cardRepository.findById(issueBookRequestDTO.getBookId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new CradNotFoundException("invalid book id");
        }

        if(card.getStatus()!= Status.ACTIVE) throw  new Exception("activate card and try again");

        if(book.isIssued()) throw new Exception("book is already issued");

        book.setIssued(true);

        transaction.setCard(card);
        transaction.setBook(book);

        card.getTransactionList().add(transaction);
        book.getTransactionList().add(transaction);

        book.setCard(card);
        card.getBooks().add(book);

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        cardRepository.save(card);

        IssueBookResponseDTO issueBookResponseDTO = new IssueBookResponseDTO();

        issueBookResponseDTO.setBookname(book.getTitle());
        issueBookResponseDTO.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDTO.setTransactionStatus(transaction.getTransactionStatus());
        Calendar cal = Calendar.getInstance();
        cal.setTime(transaction.getTransactionDate());
        cal.add(Calendar.DATE, 15);
        Date returnDate = cal.getTime();

        issueBookResponseDTO.setReturnDate(returnDate);

        return issueBookResponseDTO;
    }
}

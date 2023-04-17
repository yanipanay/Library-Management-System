package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Repository.AuthorRepository;
import com.example.Library.Management.System.Repository.BookRepository;
import com.example.Library.Management.System.Service.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public String addBook(Book book) throws Exception {

        try{
            Author auth = authorRepository.findById(book.getAuthor().getId()).get();
            auth.getBooks().add(book);
            book.setAuthor(auth);
            authorRepository.save(auth);
        }
        catch(Exception e){
                throw new Exception("Author not present");
        }
        bookRepository.save(book);

        return "book added successfuly";
    }

    public List<Book> getBooksById(int id){
        List<Book> books = bookRepository.findAll();
        List<Book> authorBooks = new ArrayList<>();
        for(Book book:books){
            if(book.getAuthor().getId()==id) authorBooks.add(book);
        }

        return authorBooks;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}

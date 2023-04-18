package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.DTO.AddBookDTO;
import com.example.Library.Management.System.DTO.BookResponseDTO;
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
    public BookResponseDTO addBook(AddBookDTO addBookDTO) throws Exception {

        try{
            Author auth = authorRepository.findById(addBookDTO.getAuthorId()).get();
            Book book = new Book();
            book.setGenere(addBookDTO.getGenere());
            book.setTitle(addBookDTO.getTitle());
            book.setPrice(addBookDTO.getPrice());
            book.setAuthor(auth);

            auth.getBooks().add(book);

            authorRepository.save(auth);
            bookRepository.save(book);

            BookResponseDTO bookResponseDTO= new BookResponseDTO();

            bookResponseDTO.setBookName(book.getTitle());

            bookResponseDTO.setAuthorName(auth.getName());

            bookResponseDTO.setPrice(book.getPrice());

            bookResponseDTO.setGenere(book.getGenere());

            return bookResponseDTO;
        }
        catch(Exception e){
                throw new Exception("Author not present");
        }
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

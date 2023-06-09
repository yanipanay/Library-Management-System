package com.example.Library.Management.System.Controllers;

import com.example.Library.Management.System.DTO.AddBookDTO;
import com.example.Library.Management.System.DTO.BookResponseDTO;
import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Service.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public BookResponseDTO addBook(@RequestBody AddBookDTO addBookDTO) throws Exception {
        return bookService.addBook(addBookDTO);
    }

    //to find books by author id

    @GetMapping("getById")
    public List<Book> getBookByID(@RequestParam("id") int id){
        return bookService.getBooksById(id);
    }

    @GetMapping("getAll")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    
}

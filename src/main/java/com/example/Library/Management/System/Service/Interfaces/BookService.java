package com.example.Library.Management.System.Service.Interfaces;

import com.example.Library.Management.System.DTO.AddBookDTO;
import com.example.Library.Management.System.DTO.BookResponseDTO;
import com.example.Library.Management.System.Entity.Book;

import java.util.List;

public interface BookService {

    public BookResponseDTO addBook(AddBookDTO addBookDTO) throws Exception;

    public List<Book> getBooksById(int id);

    public List<Book> getAll();
}

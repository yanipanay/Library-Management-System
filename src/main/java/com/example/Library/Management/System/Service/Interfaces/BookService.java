package com.example.Library.Management.System.Service.Interfaces;

import com.example.Library.Management.System.Entity.Book;

import java.util.List;

public interface BookService {

    public String addBook(Book book) throws Exception;

    public List<Book> getBooksById(int id);

    public List<Book> getAll();
}

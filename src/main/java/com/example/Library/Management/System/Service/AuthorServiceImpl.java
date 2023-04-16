package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Repository.AuthorRepository;
import com.example.Library.Management.System.Service.Interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String add(Author author){
        authorRepository.save(author);
        return "Author added successfully";
    }

}

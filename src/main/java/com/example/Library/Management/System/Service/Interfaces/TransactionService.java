package com.example.Library.Management.System.Service.Interfaces;

import com.example.Library.Management.System.DTO.IssueBookRequestDTO;
import com.example.Library.Management.System.DTO.IssueBookResponseDTO;
import com.example.Library.Management.System.Exceptions.BookNotFoundException;
import com.example.Library.Management.System.Exceptions.CradNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    public IssueBookResponseDTO issue (IssueBookRequestDTO issueBookRequestDTO) throws Exception;
}

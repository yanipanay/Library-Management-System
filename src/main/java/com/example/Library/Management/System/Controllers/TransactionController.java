package com.example.Library.Management.System.Controllers;

import com.example.Library.Management.System.DTO.IssueBookRequestDTO;
import com.example.Library.Management.System.DTO.IssueBookResponseDTO;
import com.example.Library.Management.System.Service.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public IssueBookResponseDTO issuebook(@RequestBody IssueBookRequestDTO issueBookRequestDTO) throws Exception {
      return transactionService.issue(issueBookRequestDTO);
    }
}

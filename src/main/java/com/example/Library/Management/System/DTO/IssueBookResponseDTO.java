package com.example.Library.Management.System.DTO;

import com.example.Library.Management.System.Enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueBookResponseDTO {
    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String Bookname;
    private Date returnDate;
}

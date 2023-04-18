package com.example.Library.Management.System.DTO;

import com.example.Library.Management.System.Enums.Genere;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private String bookName;
    private String AuthorName;
    private int price;
    private Genere genere;
}


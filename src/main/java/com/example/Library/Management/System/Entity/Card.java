package com.example.Library.Management.System.Entity;

import com.example.Library.Management.System.Enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date validDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn
    private Student student;
}

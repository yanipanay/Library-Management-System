package com.example.Library.Management.System.Entity;

import com.example.Library.Management.System.Enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String mobile;

    private String email;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne(mappedBy = "student")
    private Card card;
}

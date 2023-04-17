package com.example.Library.Management.System.DTO;

import com.example.Library.Management.System.Enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentReq {
    private String name;
    private String mobile;
    private String email;
    private Department department;
}

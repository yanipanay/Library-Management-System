package com.example.Library.Management.System.Service.Interfaces;

import com.example.Library.Management.System.DTO.StudentNameChangeReqDTO;
import com.example.Library.Management.System.DTO.StudentReq;
import com.example.Library.Management.System.DTO.StudentResposeDTO;
import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    public String addStudent(StudentReq student);

    public List<Student> getStudents();

    public  StudentResposeDTO getStudent(int id);

    public StudentResposeDTO updateName(StudentNameChangeReqDTO studentNameChangeReqDTO) throws StudentNotFoundException;

    public String deleteAll();

    public String deleteById(int id);
}

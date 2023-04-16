package com.example.Library.Management.System.Service.Interfaces;

import com.example.Library.Management.System.Entity.Student;

import java.util.List;

public interface StudentService {
    public String addStudent(Student student);

    public List<Student> getStudents();

    public  Student getStudent(int id);

    public String updateName(int id,String name);

    public String deleteAll();

    public String deleteById(int id);
}

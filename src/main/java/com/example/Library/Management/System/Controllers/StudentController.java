package com.example.Library.Management.System.Controllers;

import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/get")
    public Student getStudentById(@RequestParam("id") int id){
        return studentService.getStudent(id);
    }

    @PutMapping("/updateName")
    public String updateStudentName(@RequestParam("id") int id, @RequestParam("name") String name){
        return studentService.updateName(id,name);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        return studentService.deleteAll();
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam("id") int id){
        return studentService.deleteById(id);
    }
}

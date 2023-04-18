package com.example.Library.Management.System.Controllers;

import com.example.Library.Management.System.DTO.StudentNameChangeReqDTO;
import com.example.Library.Management.System.DTO.StudentReq;
import com.example.Library.Management.System.DTO.StudentResposeDTO;
import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Exceptions.StudentNotFoundException;
import com.example.Library.Management.System.Service.Interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentReq student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/get")
    public StudentResposeDTO getStudentById(@RequestParam("id") int id){

        return studentService.getStudent(id);
    }

    @PutMapping("/updateName")
    public StudentResposeDTO updateStudentName(@RequestBody StudentNameChangeReqDTO studentNameChangeReqDTO) throws StudentNotFoundException {
        return studentService.updateName(studentNameChangeReqDTO);
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

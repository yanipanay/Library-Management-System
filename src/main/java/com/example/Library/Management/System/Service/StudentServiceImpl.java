package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Card;
import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Enums.Status;
import com.example.Library.Management.System.Repository.StudentRepository;
import com.example.Library.Management.System.Service.Interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student){
        Card card = new Card();
        card.setStudent(student);
        card.setStatus(Status.ACTIVE);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 4);
        Date expiry = cal.getTime();
        card.setValidDate(expiry);

        student.setCard(card);

        studentRepository.save(student);
        return "success";
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public  Student getStudent(int id){
        return studentRepository.findById(id).get();
    }

    public String updateName(int id,String name){
        Student st = studentRepository.findById(id).get();
        st.setName(name);
        studentRepository.save(st);

        return "successfully updated";
    }

    public String deleteAll(){
        studentRepository.deleteAll();

        return "All Student data deleted";
    }

    public String deleteById(int id){
        studentRepository.deleteById(id);

        return "student data deleted";
    }


}

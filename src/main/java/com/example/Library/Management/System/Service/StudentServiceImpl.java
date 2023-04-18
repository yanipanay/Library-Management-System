package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.DTO.StudentNameChangeReqDTO;
import com.example.Library.Management.System.DTO.StudentReq;
import com.example.Library.Management.System.DTO.StudentResposeDTO;
import com.example.Library.Management.System.Entity.Card;
import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Enums.Status;
import com.example.Library.Management.System.Exceptions.StudentNotFoundException;
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
    public String addStudent(StudentReq studentDTO){

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setDepartment(studentDTO.getDepartment());
        student.setEmail(studentDTO.getEmail());
        student.setMobile(studentDTO.getMobile());

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

    public  StudentResposeDTO getStudent(int id){
        Student st= studentRepository.findById(id).get();

        StudentResposeDTO studentResposeDTO = new StudentResposeDTO();

        studentResposeDTO.setId(st.getId());
        studentResposeDTO.setDepartment(st.getDepartment());
        studentResposeDTO.setEmail(st.getEmail());
        studentResposeDTO.setMobile(st.getMobile());
        studentResposeDTO.setName(st.getName());

        return studentResposeDTO;
    }

    @Override
    public StudentResposeDTO updateName(StudentNameChangeReqDTO studentNameChangeReqDTO) throws StudentNotFoundException {
        int id = studentNameChangeReqDTO.getId();
        String name = studentNameChangeReqDTO.getName();
        try{
            Student st = studentRepository.findById(id).get();
            st.setName(name);
            Student updatedStudent = studentRepository.save(st);


            StudentResposeDTO studentResposeDTO = new StudentResposeDTO();

            studentResposeDTO.setId(st.getId());
            studentResposeDTO.setDepartment(st.getDepartment());
            studentResposeDTO.setEmail(st.getEmail());
            studentResposeDTO.setMobile(st.getMobile());
            studentResposeDTO.setName(st.getName());

            return studentResposeDTO;

        }
        catch(Exception e){
                throw new StudentNotFoundException("invalid id");
        }


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

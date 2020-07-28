package com.yy.student.dal.studentdal;

import com.yy.student.dal.studentdal.entities.Student;
import com.yy.student.dal.studentdal.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent(){
        Student student=new Student();
        student.setName("john");
        student.setCourse("Java Web Services");
        student.setFee(30d);
        studentRepository.save(student);
    }

    @Test
    public void testFindStudentById(){
        Optional<Student> s=studentRepository.findById(1l);
        Student student=s.get();
        System.out.println(student);
    }

    @Test
    public void updateStudent(){
        Student student=studentRepository.findById(1l).get();
        student.setFee(40d);
        studentRepository.save(student);
    }

    @Test
    public void testDeleteStudent(){
        studentRepository.deleteById(1l);
    }
}

package com.sidhu.SpringJDBCPostgresql.service;

import com.sidhu.SpringJDBCPostgresql.model.Student;
import com.sidhu.SpringJDBCPostgresql.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo sr;

    public StudentRepo getSr() {
        return sr;
    }

    @Autowired
    public void setSr(StudentRepo sr) {
        this.sr = sr;
    }

    public void addStudent(Student s){
        sr.save(s);
    }

    public List<Student> getStudents(){
        return sr.findAll();
    }
}

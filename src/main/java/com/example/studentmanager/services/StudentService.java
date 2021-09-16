package com.example.studentmanager.services;

import com.example.studentmanager.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StudentService {//in the same package create a class which implements this interface
    //create a method for listing ALL the students
    List<Student> getAllStudents();
    //add method that adds new students into the system
    void saveStudent(Student student);


}

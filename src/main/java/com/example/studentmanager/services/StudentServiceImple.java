package com.example.studentmanager.services;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImple implements StudentService{
    @Autowired//injecting employeeRepository using the autowired annotation
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();//returns all the students in a list to the controller

    }
}

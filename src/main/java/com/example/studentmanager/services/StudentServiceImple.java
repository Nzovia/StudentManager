package com.example.studentmanager.services;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImple implements StudentService{
    @Autowired//injecting employeeRepository using the autowired annotation
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();//returns all the students in a list to the controller

    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optional= studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()){
            student = optional.get();
        } else{
            throw new RuntimeException("student not found...."+ id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(Integer id) {
        this.studentRepository.deleteById(id);
    }

}

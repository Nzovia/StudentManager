package com.example.studentmanager.repository;

import com.example.studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//annotate with add add repository, helps us get CRUD operation for student entity using
//JPA repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}

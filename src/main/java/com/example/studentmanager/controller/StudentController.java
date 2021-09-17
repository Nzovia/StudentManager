package com.example.studentmanager.controller;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller  //annotates with controller for it to be identified as a controller
public class StudentController {

    @Autowired//inject the service class
    private StudentService studentService;
    //create method handler for home page (index.html) which will display the list of students
    //display the list of students
    @GetMapping("/")
    public  String viewHomePage(Model model){
        //add data to the model using the add attribute
        model.addAttribute("listStudents",studentService.getAllStudents());//object attribute
        return "index";//return view name
        //the above code means we have retrieved the list of employees and added them to the model
    }

    @GetMapping("/showNewStudentForm")
    public String addStudentForm(Model model){
        //here we create an attribute to bind form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "addStudentForm";
    }

//    @DeleteMapping("")
//    public  String deleteBook(Student student){
//        //delete student from the database
//        studentService.deleteStudent(student);
//        return "redirect:/";
//
//    }
    @PostMapping("/addStudent")
    public String addStudent(Student student){
        //add student to the database so we call student service
        studentService.saveStudent(student);
        return "redirect:/"; //redirection to the homepage

    }
    //method handler for updating requests
    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") Integer id, Model model){//means add data to the model
        //to  bind id we use pathVariable annotation
        //get employee from te service
        Student student = studentService.getStudentById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("student",student);
        return "addStudentForm";

    }
    //method handler for deleting requests
    @GetMapping("/deleteStudent/{id}")
    public  String deleteEmployee(@PathVariable(value = "id") Integer id){
        //call the delete method from the service class
        this.studentService.deleteStudentById(id);
        return "redirect:/"; //redirection to the homepage once you delete an employee

    }
    
}

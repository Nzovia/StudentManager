package com.example.studentmanager.controller;

import com.example.studentmanager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    
}

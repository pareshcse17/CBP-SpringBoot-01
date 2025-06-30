package com.example.hostelmanagement.controller;

import com.example.hostelmanagement.dto.StudentDTO;
import com.example.hostelmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody StudentDTO student) {
        studentService.addStudent(student);
    }
}

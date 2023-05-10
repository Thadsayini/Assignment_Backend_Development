package com.example.informationsystem.controller;

import com.example.informationsystem.model.Student;
import com.example.informationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) {
           return studentService.save(student);

        }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student student = studentService.findById(id);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setSurname(updatedStudent.getSurname());
            studentService.save(student);
        } else {
            return null;
        }
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteById(id);
    }
}

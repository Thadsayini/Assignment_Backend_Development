package com.example.informationsystem.service;

import com.example.informationsystem.model.Student;
import com.example.informationsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        studentRepository.save(student);

        return student;
    }
}


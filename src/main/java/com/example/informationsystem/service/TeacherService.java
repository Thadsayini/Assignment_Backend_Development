package com.example.informationsystem.service;

import com.example.informationsystem.model.Teacher;
import com.example.informationsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher) {
        teacherRepository.save(teacher);

        return teacher;
    }

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    public void findById(int id) {
        teacherRepository.findById(id);

    }
}

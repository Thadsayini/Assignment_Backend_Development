package com.example.informationsystem.service;

import com.example.informationsystem.model.Student;
import com.example.informationsystem.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {
        List<Student> expectedStudents = Arrays.asList(
                new Student(1,"Aro" ,"Abi"),
                new Student(2,"Hab","Lin")
        );

        Mockito.when(studentRepository.findAll()).thenReturn(expectedStudents);

        List<Student> actualStudents = studentService.findAll();

        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    void findById() {

        int studentId = 1;
        Student expectedStudent = new Student(studentId, "Aro" ,"Abi");

        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(expectedStudent));

        Student actualStudent = studentService.findById(studentId);

        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    void saveStudent() {

        Student studentToSave = new Student( null, "Aro","Abi");

        Student savedStudent = new Student(1, "Aro","Abi");

        Mockito.when(studentRepository.save(studentToSave)).thenReturn(savedStudent);
        Student actualSavedStudent = studentService.saveStudent(studentToSave);

        assertEquals(savedStudent, actualSavedStudent);
    }

    @Test
    void deleteById() {
        int studentIdToDelete = 1;

        studentService.deleteById(studentIdToDelete);

        Mockito.verify(studentRepository, Mockito.times(1)).deleteById(studentIdToDelete);
    }

    @Test
    void save() {
        int studentId = 1;
        Student studentToUpdate = new Student(studentId, "Aro","Abi");

        Student updatedStudent = new Student(studentId, "Aro","Abi");

        Mockito.when(studentRepository.save(studentToUpdate)).thenReturn(updatedStudent);

        Student actualUpdatedStudent = studentService.save(studentToUpdate);

        assertEquals(updatedStudent, actualUpdatedStudent);
    }
}
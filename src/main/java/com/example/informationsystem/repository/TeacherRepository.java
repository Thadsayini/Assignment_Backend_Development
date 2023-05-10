package com.example.informationsystem.repository;

import com.example.informationsystem.model.Student;
import com.example.informationsystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    void findById(int id);
}

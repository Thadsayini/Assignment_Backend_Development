package com.example.informationsystem.repository;


import java.util.List;
import java.util.Optional;
import com.example.informationsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


}

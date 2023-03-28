package com.ssau.study.repository;

import com.ssau.study.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {



    List<Student> findByNameContainingIgnoreCase(String name);


//
//    List<Student> findAll();
//
//    List<Student> findAllByName(String name);
//
//    Student addStudent(Student student);
//
//    Student updateStudent(Student student);
//
//    Boolean deleteStudent(long id);
//
//    Student findById(long id);
}

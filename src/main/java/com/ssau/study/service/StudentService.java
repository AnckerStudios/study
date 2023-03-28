package com.ssau.study.service;

import com.ssau.study.entity.Student;
import com.ssau.study.pojo.StudentPojo;
import com.ssau.study.repository.GroupRepository;
import com.ssau.study.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository){
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public long count() {
        return studentRepository.count();
    }

    public List<StudentPojo> findAll(String name) {
        List<StudentPojo> result = new ArrayList<>();
        for(Student student : name == null ? studentRepository.findAll() : studentRepository.findByNameContainingIgnoreCase(name)){
            result.add(StudentPojo.fromEntity(student));
        }
        return result;
    }
    public StudentPojo save(StudentPojo studentPojo) {
        Student student = StudentPojo.toEntity(studentPojo);
        if(studentPojo.getGroup() != null) {
            student.setGroup(groupRepository.findById(studentPojo.getGroup()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Группы нет")
            ));
        }
        return StudentPojo.fromEntity(studentRepository.save(student));
    }

//    public StudentPojo update(StudentPojo studentPojo) {
//        Student student = StudentPojo.toEntity(studentPojo);
//        student.setGroup(groupRepository.findById(studentPojo.getGroup()).orElseThrow());
//        return StudentPojo.fromEntity(studentRepository.save(student));
//    }

    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }

    public StudentPojo findById(long id) {
        return StudentPojo.fromEntity(studentRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Студента нет")
        ));
    }

    public long saveAll(){
        List<Student> students = new ArrayList<>();
        for(long i = 0; i<100; i++){
            students.add(new Student(i,"name"+i,new Date(),1,null));
        }
        long startTime = System.currentTimeMillis();
        studentRepository.saveAll(students);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Время = "+duration);
        return duration;
    }


}

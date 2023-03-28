package com.ssau.study.controller;

import com.ssau.study.entity.Student;
import com.ssau.study.pojo.StudentPojo;
import com.ssau.study.repository.DemoRepo;
import com.ssau.study.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final DemoRepo demoRepo;
    public StudentController(StudentService studentService, DemoRepo demoRepo){
        this.studentService = studentService;
        this.demoRepo = demoRepo;
    }

    @GetMapping("/count")
    public long count() {
        return studentService.count();
    }

    @GetMapping
    public List<StudentPojo> findAll() {
        return studentService.findAll(null);
    }

    @GetMapping("/findByName/{name}")
    public List<StudentPojo> findAllByName(@PathVariable String name) {
        return studentService.findAll(name);
    }

    @PostMapping
    public StudentPojo addStudent(@RequestBody StudentPojo student){
        return studentService.save(student);
    }
    @PutMapping
    public StudentPojo updateStudent(@RequestBody StudentPojo student){
        return studentService.save(student);
    }
    @DeleteMapping
    public void deleteStudent(@RequestParam long id){
        studentService.deleteById(id);
    }

    @GetMapping("/findById")
    public StudentPojo findAllById(@RequestParam long id) {
        return studentService.findById(id);
    }

    @GetMapping("/saveAll")
    public long saveAll() {
        return studentService.saveAll();
    }

    @GetMapping("/saveAll2")
    public long saveAll2() {
        List<Student> students = new ArrayList<>();
        for(long i = 0; i<100; i++){
            students.add(new Student(i,"name"+i,new Date(),1,null));
        }
        long startTime = System.currentTimeMillis();
        demoRepo.saveAll2(students);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Время = "+duration);
        return duration;
    }



}

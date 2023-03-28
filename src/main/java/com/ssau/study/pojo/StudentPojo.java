package com.ssau.study.pojo;

import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentPojo {
    private Long id;
    private String name;
    private Date birthdate;
    private int number;

    private Long group;

    public static StudentPojo fromEntity(Student student){
        StudentPojo pojo = new StudentPojo();
        pojo.setId(student.getId());
        pojo.setName(student.getName());
        pojo.setBirthdate(student.getBirthdate());
        pojo.setNumber(student.getNumber());
        if(student.getGroup() != null)
            pojo.setGroup(student.getGroup().getId());
        return pojo;
    }

    public static Student toEntity(StudentPojo pojo){
        Student student = new Student();
        student.setId(pojo.getId());
        student.setName(pojo.getName());
        student.setBirthdate(pojo.getBirthdate());
        student.setNumber(pojo.getNumber());

        return student;
    }
}

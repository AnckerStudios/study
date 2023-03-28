package com.ssau.study.pojo;

import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GroupPojo {
    private Long id;
    private String name;
    private List<StudentPojo> students;

    public static GroupPojo fromEntity(Group group){
        GroupPojo pojo = new GroupPojo();
        pojo.setId(group.getId());
        pojo.setName(group.getName());
        List<StudentPojo> students = new ArrayList<>();
        pojo.setStudents(students);
        for(Student student : group.getStudents()){
            students.add(StudentPojo.fromEntity(student));
        }
        return pojo;
    }
    public static Group toEntity(GroupPojo pojo){
        Group group = new Group();
        group.setId(pojo.getId());
        group.setName(pojo.getName());
        List<Student> studentList = new ArrayList<>();
        group.setStudents(studentList);
        if(pojo.getStudents() != null) {
            for (StudentPojo studentPojo : pojo.getStudents()) {
                studentList.add(StudentPojo.toEntity(studentPojo));
            }
        }
        return group;
    }
}

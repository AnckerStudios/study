package com.ssau.study.service;

import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import com.ssau.study.pojo.GroupPojo;
import com.ssau.study.pojo.StudentPojo;
import com.ssau.study.repository.GroupRepository;
import com.ssau.study.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;


    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    public long count() {
        return groupRepository.count();
    }

    public GroupPojo findById(long id) {
        return GroupPojo.fromEntity(groupRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Группы нет")
        ));
    }
    public List<GroupPojo> findAll(String name) {
        List<GroupPojo> result = new ArrayList<>();
        for(Group group : name == null ? groupRepository.findAll() : groupRepository.findByNameContainingIgnoreCase(name)){
            result.add(GroupPojo.fromEntity(group));
        }
        return result;
    }



    public GroupPojo save(GroupPojo groupPojo) {
        Group group = GroupPojo.toEntity(groupPojo);
        if(groupPojo.getStudents() != null) {
            for (Student student : group.getStudents()) {
                student.setGroup(group);
            }
        }
        return GroupPojo.fromEntity(groupRepository.save(group));
    }

    public GroupPojo update(GroupPojo group) {
        return GroupPojo.fromEntity(groupRepository.save(GroupPojo.toEntity(group)));
    }

    public void delete(long id) {
        groupRepository.deleteById(id);
    }




}

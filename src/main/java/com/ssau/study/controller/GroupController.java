package com.ssau.study.controller;

import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import com.ssau.study.pojo.GroupPojo;
import com.ssau.study.pojo.StudentPojo;
import com.ssau.study.repository.StudentRepository;
import com.ssau.study.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @GetMapping("/count")
    public long count() {
        return groupService.count();
    }

    @GetMapping
    public List<GroupPojo> findAll() {
        return groupService.findAll(null);
    }

    @GetMapping("/findByName/{name}")
    public List<GroupPojo> findAllByName(@PathVariable String name) {
        return groupService.findAll(name);
    }
    @GetMapping("/findById")
    public GroupPojo findById(@RequestParam long id) {
        return groupService.findById(id);
    }
    @PostMapping
    public GroupPojo addGroup(@RequestBody GroupPojo group){
        return groupService.save(group);
    }
    @PutMapping
    public GroupPojo updateGroup(@RequestBody GroupPojo group){
        return groupService.save(group);
    }
    @DeleteMapping
    public void deleteGroup(@RequestParam long id){
        groupService.delete(id);
    }

//    @PostMapping("{groupId}/students")
//    public StudentPojo createStudent(@PathVariable long groupId, @RequestBody StudentPojo studentPojo){
//        return groupService.createStudent(groupId,studentPojo);
//    }
}

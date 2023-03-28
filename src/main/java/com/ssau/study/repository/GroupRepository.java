package com.ssau.study.repository;

import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface GroupRepository extends JpaRepository<Group,Long> {
    List<Group> findByNameContainingIgnoreCase(String name);
}

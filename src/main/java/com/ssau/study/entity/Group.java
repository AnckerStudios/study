package com.ssau.study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "groups",schema="public",uniqueConstraints = {@UniqueConstraint(columnNames="name")})
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",columnDefinition = "text",length = 100,nullable = false,unique = true)
    private String name;
    @OneToMany(mappedBy = "group",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;
}

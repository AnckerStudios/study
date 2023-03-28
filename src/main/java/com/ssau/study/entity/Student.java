package com.ssau.study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="students",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(value = TemporalType.DATE)
    private Date birthdate;
    private int number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id",foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Group group;
}

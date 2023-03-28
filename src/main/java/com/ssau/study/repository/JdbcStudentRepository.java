package com.ssau.study.repository;

import com.ssau.study.entity.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class JdbcStudentRepository implements DemoRepo {
    private final JdbcTemplate jdbcTemplate;
    //private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Transactional
    public void saveAll2(List<Student> students) {
        List<Object[]> values = new ArrayList<>();
        for (Student student : students) {
            Object[] item = new Object[] { student.getName(), student.getBirthdate(), student.getNumber() };
            values.add(item);
        }
        jdbcTemplate.batchUpdate("INSERT INTO public.students (name, birthdate, number) VALUES (?, ?, ?)",
                values);
    }
}

package com.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.commonmodels.entity.Student;
import org.commonmodels.response.StudentResponse;
import com.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private StudentService studentService;

    public StudentResponse student(long id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);
        return new StudentResponse(studentOptional.isPresent() ? studentOptional.get() : null);
    }
}

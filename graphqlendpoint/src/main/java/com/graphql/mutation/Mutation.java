package com.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.commonmodels.request.CreateStudentRequest;
import org.commonmodels.response.StudentResponse;
import com.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest studentRequest) {
        return new StudentResponse(studentService.createStudent(studentRequest));
    }

}

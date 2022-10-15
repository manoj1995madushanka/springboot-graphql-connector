package com.restendpoint.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.commonmodels.entity.Address;
import org.commonmodels.entity.Student;
import org.commonmodels.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RestStudentServiceImpl implements RestStudentService {

    @Autowired
    private GraphQlAccessorService graphQlAccessorService;

    @Override
    public StudentResponse getFirstNameById(long id) {
        try {
            return graphQlAccessorService.getStudent(id);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private StudentResponse generateMockStudent() {
        Student student = new Student();
        student.setId(1l);
        student.setFirstName("manoj");
        student.setLastName("madushanka");
        Address address = new Address();
        address.setCity("galle");
        address.setId(1l);
        address.setStreet("ad street");
        student.setAddress(address);
        student.setLearningSubjects(Collections.emptyList());
        return new StudentResponse(student);
    }
}

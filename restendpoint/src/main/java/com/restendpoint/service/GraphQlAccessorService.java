package com.restendpoint.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.commonmodels.response.StudentResponse;
import org.springframework.stereotype.Service;

@Service
public interface GraphQlAccessorService {
    StudentResponse getStudent(long id) throws JsonProcessingException;
}

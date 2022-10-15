package com.restendpoint.service;

import org.commonmodels.response.StudentResponse;
import org.springframework.stereotype.Service;

@Service
public interface RestStudentService {
    StudentResponse getFirstNameById(long id);
}

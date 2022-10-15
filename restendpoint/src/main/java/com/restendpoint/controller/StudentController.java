package com.restendpoint.controller;

import com.restendpoint.service.RestStudentService;
import org.commonmodels.entity.Student;
import org.commonmodels.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    RestStudentService restStudentService;

    @GetMapping("getById/{id}")
    public StudentResponse getFirstNameById (@PathVariable long id) {
        return restStudentService.getFirstNameById(id);
    }

}


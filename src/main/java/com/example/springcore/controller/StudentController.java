package com.example.springcore.controller;

import com.example.springcore.dto.req.StudentRequest;
import com.example.springcore.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentService service;

    public void setStudentService(StudentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<Integer> create(@RequestBody @Valid StudentRequest request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }


}

package com.example.springcore.controller;

import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.entity.Faculty;
import com.example.springcore.service.FacultyService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public ResponseEntity<List<FacultyResponse>> getAll() {
        return new ResponseEntity<>(facultyService.getAll(), HttpStatus.CREATED);
    }
}

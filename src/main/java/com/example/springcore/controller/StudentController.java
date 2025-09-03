package com.example.springcore.controller;


import com.example.springcore.dto.req.StudentRequest;
import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.dto.res.StudentResponse;
import com.example.springcore.entity.Student;
import com.example.springcore.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
  StudentService studentService;


  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public ResponseEntity<List<StudentResponse>> getStudents(){
    return new ResponseEntity<>(studentService.getAll(), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentResponse> getStudentById(@PathVariable Integer id){
    return ResponseEntity.ok(studentService.getById(id));
  }

  @GetMapping("/faculty-name")
  public ResponseEntity<List<StudentResponse>> getFacultyNames(@RequestParam("facultyName") String facultyName){
    return new ResponseEntity<>(studentService.findByFacultyName(facultyName), HttpStatus.OK);
  };

  @PostMapping()
  public ResponseEntity<Integer> saveStudent(@RequestBody @Valid StudentRequest studentRequest){
    return  ResponseEntity.ok(studentService.create(studentRequest));
  }


}

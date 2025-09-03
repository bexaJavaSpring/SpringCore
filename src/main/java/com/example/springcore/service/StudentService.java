package com.example.springcore.service;

import com.example.springcore.dto.req.StudentRequest;
import com.example.springcore.dto.res.StudentResponse;
import com.example.springcore.entity.Student;
import com.example.springcore.mapper.StudentMapper;
import com.example.springcore.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {
  StudentRepository studentRepository;
  StudentMapper mapper;

  public List<StudentResponse> getAll() {
    return studentRepository.findAll().stream().map(mapper::toDto).toList();
  }

  public StudentResponse getById(Integer studentId) {
    Optional<Student> optionalStudent = studentRepository.findById(studentId);
    if (!optionalStudent.isPresent()) {
      throw new RuntimeException("Student not found");
    }
    Student student = optionalStudent.get();
    return mapper.toDto(student);
  }

  public List<StudentResponse> findByFacultyName(String facultyName) {
    return studentRepository.findAllByFacultyName(facultyName).stream().map(mapper::toDto).toList();
  }

  public Integer create(StudentRequest studentRequest) {
    Student student = new Student();
    student.setFirstName(studentRequest.getFirstName());
    student.setLastName(studentRequest.getLastName());
    student.setEmail(studentRequest.getEmail());
    student.setAge(studentRequest.getAge());
    student.setMiddleName(studentRequest.getMiddleName());
    student.setFaculty(studentRequest.getFaculty());

    Student newStudent = studentRepository.save(student);
    return newStudent.getId();
  }


}

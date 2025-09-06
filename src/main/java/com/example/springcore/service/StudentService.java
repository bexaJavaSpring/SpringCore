package com.example.springcore.service;

import com.example.springcore.dto.req.StudentRequest;
import com.example.springcore.entity.Faculty;
import com.example.springcore.entity.Student;
import com.example.springcore.repository.FacultyRepository;
import com.example.springcore.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Integer create(StudentRequest request) {
        Student student = new Student();
        student.setEmail(request.getEmail());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setMiddleName(request.getMiddleName());
        student.setAge(request.getAge());
//        facultyRepository.getReferenceById(request.getFacultyId());
        Faculty faculty = facultyRepository.findByIdCustom(request.getFacultyId());
        if (faculty == null) {
            throw new RuntimeException("Faculty not found");
        }
        student.setFaculty(faculty);
        Student newStudent = studentRepository.save(student);
        return newStudent.getId();
    }
}

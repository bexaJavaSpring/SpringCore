package com.example.springcore.controller;

import com.example.springcore.dto.req.FacultyRequest;
import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.entity.Faculty;
import com.example.springcore.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     // = @ResponseBody + @Controller
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

    @PostMapping("/create")
    public ResponseEntity<Integer> create(@RequestBody @Valid FacultyRequest request){
        return ResponseEntity.ok(facultyService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyResponse> getById(@PathVariable("id") Integer facultyId){
        return ResponseEntity.ok(facultyService.getById(facultyId));
    }

    @PostMapping("/get-by-name")
    public ResponseEntity<FacultyResponse> getByName(@RequestParam("name") String name){
        return ResponseEntity.ok(facultyService.getByName(name));
    }
}

package com.example.springcore.controller;

import com.example.springcore.dto.req.FacultyRequest;
import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.service.FacultyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController     // = @ResponseBody + @Controller
@RequestMapping("/faculty")
//@Hidden
@Tag(name = "Faculty Controller", description = "Operations related to faculties management")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping()
    public ResponseEntity<List<FacultyResponse>> getAll() {
        return new ResponseEntity<>(facultyService.getAll(), HttpStatus.CREATED);
    }

    @PostMapping
    @Operation(description = "bu api facultetni yaratadi")
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

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer facultyId, @RequestBody FacultyRequest request){
        return ResponseEntity.ok(facultyService.update(facultyId, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer facultyId) {
        return ResponseEntity.ok(facultyService.delete(facultyId));
    }

    @PostMapping(value = "/upload-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> uploadFile(@RequestParam("file") MultipartFile file) {
       return null;
    }
}

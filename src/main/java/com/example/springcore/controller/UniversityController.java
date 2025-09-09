package com.example.springcore.controller;

import com.example.springcore.dto.req.UniversityRequest;
import com.example.springcore.dto.res.UniversityResponse;
import com.example.springcore.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
@RequiredArgsConstructor
public class UniversityController {
  private final UniversityService universityService;

  @GetMapping
  public ResponseEntity<List<UniversityResponse>> getAllUniversity() {
    return new ResponseEntity<>(universityService.getAll(), HttpStatus.OK);
  }

  @PostMapping
//  public ResponseEntity<Integer> createUniversity(@RequestParam String name, @RequestParam String address) {
//    return ResponseEntity.ok(universityService.createUniver(name, address));
//  }
  public ResponseEntity<Integer> createUniversity(@RequestBody @Valid UniversityRequest universityRequest) {
    return ResponseEntity.ok(universityService.createUniver(universityRequest));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateUniversity(@PathVariable Integer id, @RequestBody UniversityRequest universityRequest) {
    return ResponseEntity.ok(universityService.updateUniver(id, universityRequest));
  }


}

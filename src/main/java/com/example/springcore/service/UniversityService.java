package com.example.springcore.service;

import com.example.springcore.dto.req.UniversityRequest;
import com.example.springcore.dto.res.UniversityResponse;
import com.example.springcore.entity.University;
import com.example.springcore.exception.GenericNotFoundException;
import com.example.springcore.mapper.UniversityMapper;
import com.example.springcore.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class UniversityService {
  private final UniversityRepository universityRepository;
  private final UniversityMapper universityMapper;


  public List<UniversityResponse> getAll() {
    return universityRepository.findAll().stream().map(universityMapper::toDTO).toList();
  }

//  public Integer createUniver(String name, String address) {
//     University university = University.builder()
//         .name(name)
//         .address(address)
//         .build();
//
//     universityRepository.save(university);
//     return university.getId();
//  }

  public Integer createUniver(UniversityRequest universityRequest) {
    University university = new University();
    university.setName(universityRequest.getName());
    university.setAddress(universityRequest.getAddress());
    universityRepository.save(university);
    return university.getId();
  }

  public Integer updateUniver(Integer id, UniversityRequest universityRequest) {
//    Optional<University> university = universityRepository.findById(id);
    University university = universityRepository.findById(id).orElseThrow(() -> new GenericNotFoundException("University not found"));
    university.setName(universityRequest.getName());
    university.setAddress(universityRequest.getAddress());
    universityRepository.save(university);
    return university.getId();
  }
}

package com.example.springcore.service;

import com.example.springcore.dto.filter.UniversityFilter;
import com.example.springcore.dto.req.UniversityRequest;
import com.example.springcore.dto.res.UniversityResponse;
import com.example.springcore.entity.University;
import com.example.springcore.exception.GenericNotFoundException;
import com.example.springcore.mapper.UniversityMapper;
import com.example.springcore.repository.UniversityRepository;
import com.example.springcore.specification.UniversitySpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public Integer updateUniver(Integer id, UniversityRequest request) {
//    Optional<University> university = universityRepository.findById(id);
        University university = universityRepository.findById(id).orElseThrow(() -> new GenericNotFoundException("University not found"));
        if (!Objects.isNull(request.getName()))
            university.setName(request.getName());

        university.setAddress(request.getAddress() != null ?
                request.getAddress() : university.getAddress());
        universityRepository.save(university);
        return university.getId();
    }

  public List<UniversityResponse> allByFilter(UniversityFilter universityFilter) {
    Page<University> all = universityRepository.findAll(new UniversitySpecification(universityFilter),
            PageRequest.of(universityFilter.getPage() != null ? universityFilter.getPage() : 0,
                    universityFilter.getLimit() != null ? universityFilter.getLimit() : 20,
                    Sort.by(Sort.Direction.ASC, universityFilter.getSortBy() != null ? universityFilter.getSortBy() : "id")));
    List<University> list = all.getContent();
    return list.stream().map(universityMapper::toDTO).toList();
  }
}

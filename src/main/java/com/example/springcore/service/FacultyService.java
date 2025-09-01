package com.example.springcore.service;

import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.mapper.FacultyMapper;
import com.example.springcore.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository repository;
    private final FacultyMapper mapper;

    public List<FacultyResponse> getAll() {
        // @Mapper annotatsiya usuli
        return repository.findAll().stream().map(mapper::toDto).toList();

                // ozimizni usul
//        List<FacultyResponse> result = new ArrayList<>();
//        for (Faculty faculty : all) {
//            FacultyResponse facultyResponse = new FacultyResponse();
//            facultyResponse.setId(faculty.getId());
//            facultyResponse.setName(faculty.getName());
//            facultyResponse.setAddress(faculty.getAddress());
//            result.add(facultyResponse);
//        }
//        return result;
    }
}

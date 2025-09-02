package com.example.springcore.service;

import com.example.springcore.dto.req.FacultyRequest;
import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.entity.Faculty;
import com.example.springcore.mapper.FacultyMapper;
import com.example.springcore.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Integer create(FacultyRequest request) {
        Faculty faculty = new Faculty();
        faculty.setName(request.getName());
        faculty.setAddress(request.getAddress());
        Faculty newFaculty = repository.save(faculty);
        return newFaculty.getId();
    }

    public FacultyResponse getById(Integer facultyId) {
        Optional<Faculty> optionalFaculty = repository.findById(facultyId);
        if (!optionalFaculty.isPresent()) {
            throw new RuntimeException("Faculty not found");
        }
        Faculty faculty = optionalFaculty.get();
        return mapper.toDto(faculty);
    }

    public FacultyResponse getByName(String name) {
        Faculty faculty = repository.findByName(name);
        if (Objects.isNull(faculty)) {
            throw new RuntimeException("Faculty not found");
        }
        return mapper.toDto(faculty);
    }
}

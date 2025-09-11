package com.example.springcore.service;

import com.example.springcore.dto.filter.FacultyFilter;
import com.example.springcore.dto.req.FacultyRequest;
import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.entity.Faculty;
import com.example.springcore.exception.GenericNotFoundException;
import com.example.springcore.mapper.FacultyMapper;
import com.example.springcore.repository.FacultyRepository;
import com.example.springcore.specification.FacultySpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
//        Faculty faculty = new Faculty();
//        faculty.setName(request.getName());
//        faculty.setAddress(request.getAddress());
        Faculty faculty = Faculty.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();

        Faculty newFaculty = repository.save(faculty);
        return newFaculty.getId();
    }

    public FacultyResponse getById(Integer facultyId) {
        Optional<Faculty> optionalFaculty = repository.findById(facultyId);
        if (!optionalFaculty.isPresent()) {
            throw new GenericNotFoundException("Faculty not found");
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

    public String update(Integer facultyId, FacultyRequest request) {
        Faculty faculty = repository.findById(facultyId).orElseThrow(() -> new RuntimeException("Faculty not found"));
        faculty.setName(request.getName());
        if (request.getAddress() != null)
            faculty.setAddress(request.getAddress());
        repository.save(faculty);
        return "Successfully updated";
    }

    public Boolean delete(Integer facultyId) {
        repository.findById(facultyId).orElseThrow(() -> new RuntimeException("Faculty not found"));
        repository.deleteById(facultyId);
        return true;
    }

    public List<FacultyResponse> allByFilter(FacultyFilter filter) {
        Page<Faculty> all = repository.findAll(new FacultySpecification(filter),
                PageRequest.of(filter.getPage() != null ? filter.getPage() : 0, filter.getLimit() != null ? filter.getLimit() : 10,
                        Sort.by(Sort.Direction.ASC, filter.getSortBy() != null ? filter.getSortBy() : "id")));
        List<Faculty> list = all.getContent();
//        List<Faculty> list = all.stream().toList();
        return mapper.toDto(list);
    }
}

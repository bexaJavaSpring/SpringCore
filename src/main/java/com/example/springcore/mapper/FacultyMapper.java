package com.example.springcore.mapper;

import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.entity.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FacultyMapper {

//    @Mapping(source = "address1", target = "address")
    FacultyResponse toDto(Faculty faculty);

    List<FacultyResponse> toDto(List<Faculty> list);
}

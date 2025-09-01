package com.example.springcore.mapper;

import com.example.springcore.dto.res.FacultyResponse;
import com.example.springcore.entity.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FacultyMapper {

//    @Mapping(source = "address1", target = "address")
    FacultyResponse toDto(Faculty faculty);
}

package com.example.springcore.mapper;

import com.example.springcore.dto.res.UniversityResponse;
import com.example.springcore.entity.University;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UniversityMapper {

  UniversityResponse toDTO(University university);
}

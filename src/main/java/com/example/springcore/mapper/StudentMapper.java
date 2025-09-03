package com.example.springcore.mapper;

import com.example.springcore.dto.res.StudentResponse;
import com.example.springcore.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
  StudentResponse toDto(Student student);
}

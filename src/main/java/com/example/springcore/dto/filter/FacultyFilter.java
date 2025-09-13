package com.example.springcore.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultyFilter extends BaseFilter {
    private String name;
    private String address;
    private Integer universityId;
    private String universityName;
}

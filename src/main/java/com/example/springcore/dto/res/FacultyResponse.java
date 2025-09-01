package com.example.springcore.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class FacultyResponse {
    private Integer id;
    private String name;
    private String address;
}

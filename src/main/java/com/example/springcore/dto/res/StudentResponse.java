package com.example.springcore.dto.res;

import com.example.springcore.entity.Faculty;
import com.example.springcore.entity.Student;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponse {
  private String name;
  private String lastName;
  private String middleName;
  private Integer age;
  private String email;
  private Faculty faculty;

}

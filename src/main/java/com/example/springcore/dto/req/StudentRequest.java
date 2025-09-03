package com.example.springcore.dto.req;

import com.example.springcore.entity.Faculty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequest {
  @NotNull
  private String firstName;
  @NotNull
  private String lastName;
  @NotNull
  private String email;
  @NotNull
  private Integer age;
  private String middleName;
  @NotNull
  private Faculty faculty;
}

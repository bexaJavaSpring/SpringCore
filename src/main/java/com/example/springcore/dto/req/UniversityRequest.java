package com.example.springcore.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UniversityRequest {

  @NotNull(message = "name should not be null")
  @NotBlank(message = "name should not be blank")
  private String name;
  private String address;
}


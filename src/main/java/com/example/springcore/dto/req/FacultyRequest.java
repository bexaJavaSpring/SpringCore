package com.example.springcore.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultyRequest {
    @NotNull(message = "name must not be null")
    @NotBlank(message = "name must not be blank")
//    @NotEmpty(message = "name must not be null and blank")
    private String name;
    private String address;
}

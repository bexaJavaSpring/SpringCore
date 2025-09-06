package com.example.springcore.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
//    @Schema(hidden = true)
    private String email;
    private Integer age;
    private String middleName;
    @NotNull(message = "faculty is must not be null")
    private Integer facultyId;
}

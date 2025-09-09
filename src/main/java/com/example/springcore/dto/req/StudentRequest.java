package com.example.springcore.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    String firstName;
    String lastName;
    //    @Schema(hidden = true)
    String email;
    Integer age;
    String middleName;
    @NotNull(message = "faculty is must not be null")
    Integer facultyId;
}

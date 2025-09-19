package com.example.springcore.dto.res;

import com.example.springcore.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UniversityResponse {

  Integer id;
  String name;
  Address address;
}

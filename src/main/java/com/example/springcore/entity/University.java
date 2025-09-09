package com.example.springcore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "universities")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class University {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String name;

  String address;

}

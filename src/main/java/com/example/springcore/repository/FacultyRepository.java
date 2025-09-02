package com.example.springcore.repository;

import com.example.springcore.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    Faculty findByName(String name);
}

package com.example.springcore.repository;

import com.example.springcore.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University,Integer> {

}

package com.example.springcore.repository;

import com.example.springcore.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UniversityRepository extends JpaRepository<University,Integer>, JpaSpecificationExecutor<University> {

}

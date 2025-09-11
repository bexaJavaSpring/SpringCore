package com.example.springcore.repository;

import com.example.springcore.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>, JpaSpecificationExecutor<Faculty> {
    Faculty findByName(String name);

    @Query("select t from Faculty t where t.id=:id")
    Faculty findByIdCustom(@Param("id") Integer facultyId);
}

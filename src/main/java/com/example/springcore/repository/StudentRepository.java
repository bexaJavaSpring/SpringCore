package com.example.springcore.repository;

import com.example.springcore.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //@Query("select t from Student t where t.faculty.name=?1")  // -->> hibernate query
//    @Query(value = "select t from students t inner join faculties f " +
//            "on f.id = t.faculty_id where f.name=?1",
//            nativeQuery = true)
    // -->> o'zimizni dehqoncha yani postgresql query
    List<Student> findAllByFacultyName(String facultyName);
}

package com.example.springcore.specification;

import com.example.springcore.dto.filter.FacultyFilter;
import com.example.springcore.entity.Faculty;
import com.example.springcore.entity.University;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FacultySpecification implements Specification<Faculty> {

    private final FacultyFilter filter;

    @Override
    public Predicate toPredicate(Root<Faculty> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getName() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
        }
        if (filter.getAddress() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), "%" + filter.getAddress().toLowerCase() + "%"));
        }
        if (filter.getUniversityId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("university").get("id"), filter.getUniversityId()));
        }
        if (filter.getUniversityName() != null) {
            Join<University, Faculty> join = root.join("university", JoinType.INNER);
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(join.get("name")),
                    "%" + filter.getUniversityName().toLowerCase() + "%"));

//            Subquery<Integer> subquery = query.subquery(Integer.class);
//            Root<Student> studentRoot = subquery.from(Student.class);
//            studentRoot.get("name");

//            String sql = "select * from faculties f inner join universities u on u.id = f.university_id" +
//                    " where lower(u.name) like ('%'+(:universityName)+'%') ";
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

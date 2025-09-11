package com.example.springcore.specification;

import com.example.springcore.dto.filter.FacultyFilter;
import com.example.springcore.entity.Faculty;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

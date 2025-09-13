package com.example.springcore.specification;

import com.example.springcore.dto.filter.UniversityFilter;
import com.example.springcore.entity.University;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class UniversitySpecification implements Specification<University> {

  private final UniversityFilter universityFilter;

  @Override
  public Predicate toPredicate(Root<University> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    List<Predicate> predicates = new ArrayList<>();
    if (universityFilter.getName() != null)
      predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + universityFilter.getName() + "%"));
    if (universityFilter.getAddress() != null)
      predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), "%"+universityFilter.getAddress()+"%"));

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }
}

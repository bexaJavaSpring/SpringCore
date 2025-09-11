package com.example.springcore.repository;

import com.example.springcore.entity.ResourceFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceFileRepository extends JpaRepository<ResourceFile, Long> {
}

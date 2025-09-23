package com.example.springcore.repository;

import com.example.springcore.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query("select t from CommentEntity t where t.post.id=?1")
    List<CommentEntity> findByPostId(Long postId);
}

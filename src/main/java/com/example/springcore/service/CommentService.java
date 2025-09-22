package com.example.springcore.service;

import com.example.springcore.dto.req.CommentRequest;
import com.example.springcore.entity.CommentEntity;
import com.example.springcore.entity.PostEntity;
import com.example.springcore.repository.CommentRepository;
import com.example.springcore.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public Long create(CommentRequest request) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent(request.getContent());
        commentEntity.setCreatedDateTime(request.getCreatedDateTime());
        PostEntity post = postRepository.findById(request.getPostId()).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setComments(List.of(commentEntity));
        postRepository.save(post);
        commentEntity.setPost(post);
        commentRepository.save(commentEntity);
        return commentEntity.getId();
    }
}

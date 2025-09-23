package com.example.springcore.service;

import com.example.springcore.dto.req.PostRequest;
import com.example.springcore.entity.CommentEntity;
import com.example.springcore.entity.PostEntity;
import com.example.springcore.exception.GenericNotFoundException;
import com.example.springcore.repository.CommentRepository;
import com.example.springcore.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public Long create(PostRequest request) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(request.getTitle());
        postEntity.setContent(request.getPostContent());
        postEntity.setCreatedDateTime(request.getCreatedDateTime());
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent(request.getCommentContent());
        commentEntity.setCreatedDateTime(request.getCreatedDateTime());
        postEntity.setComments(List.of(commentEntity));
        commentEntity.setPost(postEntity);
        postRepository.save(postEntity);
        // 1. CascadeType.Persist da @OneToMany relationship
        // da agar parent entity save qilsak child ham automatik save bo'ladi
        return postEntity.getId();
    }

    public Long update(Long id, PostRequest request) {
        Optional<PostEntity> optionalPost = postRepository.findById(id);
        if (!optionalPost.isPresent()) {
            throw new GenericNotFoundException("Post not found");
        }
        PostEntity postEntity = optionalPost.get();
        postEntity.setContent(request.getPostContent());
        postEntity.setTitle(request.getTitle());
        List<CommentEntity> list = commentRepository.findByPostId(id);
        list.stream().forEach(comment -> comment.setContent(request.getCommentContent()));
        // 2. CascadeType.MERGE da agar parent update bo'lsa child ham automatik update bo'ladi
        postRepository.save(postEntity);
        return postEntity.getId();
    }

    public Boolean delete(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new GenericNotFoundException("Post not found"));
        postRepository.delete(postEntity);
        return true;
    }
}

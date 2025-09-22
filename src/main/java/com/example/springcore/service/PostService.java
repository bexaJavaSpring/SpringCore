package com.example.springcore.service;

import com.example.springcore.dto.req.PostRequest;
import com.example.springcore.entity.PostEntity;
import com.example.springcore.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long create(PostRequest request) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(request.getTitle());
        postEntity.setContent(request.getContent());
        postEntity.setCreatedDateTime(request.getCreatedDateTime());
        PostEntity save = postRepository.save(postEntity);
        return save.getId();
    }
}

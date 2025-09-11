package com.example.springcore.service;

import com.example.springcore.entity.ResourceFile;
import com.example.springcore.exception.GenericNotFoundException;
import com.example.springcore.repository.ResourceFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ResourceFileService {
    private final ResourceFileRepository repository;

    public ResourceFile saveFile(MultipartFile file) throws IOException {
        ResourceFile resourceFile = ResourceFile.builder()
                .filename(file.getOriginalFilename())
                .contentType(file.getContentType())
                .size(file.getSize())
                .data(file.getBytes())
                .build();
        return repository.save(resourceFile);
    }

    public ResourceFile getFile(Long id) {
        return repository.findById(id).orElseThrow(() -> new GenericNotFoundException("Resource not found"));
    }
}

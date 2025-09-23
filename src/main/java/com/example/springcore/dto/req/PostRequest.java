package com.example.springcore.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostRequest {
    private String postContent;
    private String commentContent;
    private String title;
    private LocalDateTime createdDateTime;
}

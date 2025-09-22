package com.example.springcore.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentRequest {
    private String content;
    private Long useId;
    private LocalDateTime createdDateTime;
    private Long postId;
}

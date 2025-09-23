package com.example.springcore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @OneToMany(mappedBy = "post", /* cascade = CascadeType.PERSIST cascade = CascadeType.MERGE cascade = CascadeType.REMOVE*/
    cascade = CascadeType.DETACH)
    private List<CommentEntity> comments = new ArrayList<>();

}

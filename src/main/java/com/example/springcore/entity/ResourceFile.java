package com.example.springcore.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resource_files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    private String contentType;

    private Long size;

//    @Lob   faqat Postgresql da @Lob siz ishlaydi
    @Column(name = "data", columnDefinition = "BYTEA")
    private byte[] data;
}

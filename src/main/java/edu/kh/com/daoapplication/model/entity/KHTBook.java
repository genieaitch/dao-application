package edu.kh.com.daoapplication.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class KHTBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    //  @Column 작성안할 경우 기본값 (nullable = true, unique = false)
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = true)
    private  String imagePath; // 책 표지 이미지 경로 추가
}

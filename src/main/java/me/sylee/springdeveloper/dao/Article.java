package me.sylee.springdeveloper.dao;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Article {

    /*
        id (bigint, not null, primary key),
        title (varchar(255, not null),
        content (varchar(255), not null)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name ="content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name="createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updatedAt")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

}

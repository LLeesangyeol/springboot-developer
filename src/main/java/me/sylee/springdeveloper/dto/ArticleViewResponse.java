package me.sylee.springdeveloper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sylee.springdeveloper.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ArticleViewResponse (Article article){
        this.id = article.getId(); // article.id
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
        this.updatedAt = article.getUpdatedAt();

    }
}

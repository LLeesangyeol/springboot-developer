package me.sylee.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.sylee.springdeveloper.dao.Article;
import me.sylee.springdeveloper.dto.AddArticleRequest;
import me.sylee.springdeveloper.dto.ArticleResponse;
import me.sylee.springdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest articleRequest){
        Article article = blogService.save(articleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<Article> articles = blogService.findAll();
        List<ArticleResponse> result = articles.stream().map(ArticleResponse::new).toList();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/api/articles/{id}") // /api/articles/3
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponse(article));
    }
}

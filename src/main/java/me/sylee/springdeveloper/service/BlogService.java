package me.sylee.springdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sylee.springdeveloper.dao.Article;
import me.sylee.springdeveloper.dto.AddArticleRequest;
import me.sylee.springdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest articleRequest) {
        return blogRepository.save(articleRequest.toEntity());
    }
}

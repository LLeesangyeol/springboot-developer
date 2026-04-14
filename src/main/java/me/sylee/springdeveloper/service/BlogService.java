package me.sylee.springdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sylee.springdeveloper.dao.Article;
import me.sylee.springdeveloper.dto.AddArticleRequest;
import me.sylee.springdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest articleRequest) {
        return blogRepository.save(articleRequest.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found : "+id));

    }

}

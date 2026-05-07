package me.sylee.springdeveloper.controller;


import lombok.RequiredArgsConstructor;
import me.sylee.springdeveloper.dto.ArticleResponse;
import me.sylee.springdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    //    @Autowired
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleResponse> articles=blogService.findAll().stream().map(ArticleResponse::new).toList();

        model.addAttribute("articles",articles);
        return "articleList";

    }
}

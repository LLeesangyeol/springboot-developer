package me.sylee.springdeveloper.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.sylee.springdeveloper.domain.Article;
import me.sylee.springdeveloper.dto.ArticleResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymelefaExample(Model model){
        List<ArticleResponse> list = new ArrayList<>();
        for (int i =0; i<10; i++){
            ArticleResponse a = new ArticleResponse(new Article("제목"+i, i+"번째 내용"));
            list.add(a);
        }
        model.addAttribute("article", list);
//        model.addAttribute("name","홍길동");
        List<String> hobbies = List.of("운동", "독서", "음악", "등산");

        Person p = new Person(1L, "고길동", 18, hobbies);

        model.addAttribute("hobbies", hobbies);
        model.addAttribute("person", p);
        return "example"; // src/main/resources/templates/example.html

    }
}

@Getter
@Setter
@AllArgsConstructor
class Person{
    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;


}
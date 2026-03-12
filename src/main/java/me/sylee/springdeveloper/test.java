package me.sylee.springdeveloper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @GetMapping("/hi")
        public String hello(@RequestParam("name") String name){
            return "안녕하세요,"+name+"님";
    }
}

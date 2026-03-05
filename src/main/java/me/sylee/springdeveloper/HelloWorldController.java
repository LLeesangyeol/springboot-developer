package me.sylee.springdeveloper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    // http://localhost:8080/student?fristName=김&lastName=동
    @GetMapping("/student")
    public Student getStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return new Student(firstName, lastName);
        //dd
    }

    // htttp://localhost:8080/student/김/길동
    @GetMapping("/student/{firstName}/{lastName}")
    public Student getStudent2(@PathVariable("firstName")  String firstName, @PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);
    }

}

package com.margaretnjoki.hello_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello, Spring Boot!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        return "Hello " + name + "!";
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b){
        return "SUM = " + (a + b) ;
    }
}

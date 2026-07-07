package com.margaretnjoki.hello_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("/pow/{base}/{exp}")
    public int power(@PathVariable int base, @PathVariable int exp) {
        return (int) Math.pow(base, exp);
    }
}

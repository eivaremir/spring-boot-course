package com.in28minutes.unittesting.unittesting;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello-world")
    public  String HelloWorld(){
        return "Hello World";
    }
}
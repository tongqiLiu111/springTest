package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    @Value("${MY_MESSAGE:aDefaultMessage}")
    private String Message;

    @GetMapping("/reverse")
    public String test(String string){
        return new StringBuilder(string).reverse().toString();
    }

    @GetMapping("/display")
    public String getENV() {

        return Message;
    }



}

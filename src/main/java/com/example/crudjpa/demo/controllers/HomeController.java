package com.example.crudjpa.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String index(){
        return "home";
    }
}

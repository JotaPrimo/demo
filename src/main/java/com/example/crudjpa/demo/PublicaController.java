package com.example.crudjpa.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class PublicaController {
    @GetMapping("")
    public String index(RedirectAttributes redirectAttributes){
        return "redirect:/professores";
    }
}

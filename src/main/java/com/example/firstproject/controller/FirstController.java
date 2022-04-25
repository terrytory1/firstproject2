package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/meet")
    public String practicemeet(Model model) {
        model.addAttribute("username", "테리");
        return "greetings";
    }
}

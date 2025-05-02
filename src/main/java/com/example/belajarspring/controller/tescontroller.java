package com.example.belajarspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class tescontroller {
    @GetMapping("/welcome")
    public String showWelcome() {
        return "welcome";
    }

    // @GetMapping("/mahasiswa")
    // public String showHello() {
    // return "mahasiswa";
    // }

}

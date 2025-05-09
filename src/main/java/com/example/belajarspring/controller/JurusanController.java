package com.example.belajarspring.controller;

import com.example.belajarspring.model.Jurusan;
import com.example.belajarspring.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jurusan")
public class JurusanController {
    @Autowired
    private JurusanService jurusanService;

    @GetMapping
    public String listJurusan(Model model) {
        model.addAttribute("jurusanList", jurusanService.getAllJurusan());
        return "jurusan/index";
    }

    @GetMapping("/add")
    public String addJurusanForm(Model model) {
        model.addAttribute("jurusan", new Jurusan());
        return "jurusan/add";
    }

    @PostMapping("/add")
    public String saveJurusan(@ModelAttribute Jurusan jurusan) {
        jurusanService.saveJurusan(jurusan);
        return "redirect:/jurusan";
    }
}
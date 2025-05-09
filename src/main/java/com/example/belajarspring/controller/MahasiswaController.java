package com.example.belajarspring.controller;

import com.example.belajarspring.model.Mahasiswa;
import com.example.belajarspring.service.JurusanService;
import com.example.belajarspring.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private JurusanService jurusanService;

    @GetMapping
    public String listMahasiswa(Model model) {
        model.addAttribute("mahasiswaList", mahasiswaService.getAllMahasiswa());
        return "mahasiswa/index";
    }

    @GetMapping("/add")
    public String addMahasiswaForm(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        model.addAttribute("jurusanList", jurusanService.getAllJurusan());
        return "mahasiswa/add";
    }

    @PostMapping("/add")
    public String saveMahasiswa(@ModelAttribute Mahasiswa mahasiswa) {
        mahasiswaService.saveMahasiswa(mahasiswa);
        return "redirect:/mahasiswa";
    }

    @GetMapping("/delete/{id}")
    public String deleteMahasiswa(@PathVariable Long id) {
        mahasiswaService.deleteMahasiswa(id);
        return "redirect:/mahasiswa";
    }
}
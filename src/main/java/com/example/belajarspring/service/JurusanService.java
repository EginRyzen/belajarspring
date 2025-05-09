package com.example.belajarspring.service;

import com.example.belajarspring.model.Jurusan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JurusanService {
    private final List<Jurusan> jurusanList = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Jurusan> getAllJurusan() {
        return jurusanList;
    }

    public Jurusan saveJurusan(Jurusan jurusan) {
        if (jurusan.getId() == null) {
            jurusan.setId(idCounter++);
            jurusanList.add(jurusan);
        }
        return jurusan;
    }
}
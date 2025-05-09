package com.example.belajarspring.service;

import com.example.belajarspring.model.Mahasiswa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaService {
    private final List<Mahasiswa> mahasiswaList = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaList;
    }

    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        if (mahasiswa.getId() == null) {
            mahasiswa.setId(idCounter++);
            mahasiswaList.add(mahasiswa);
        } else {
            deleteMahasiswa(mahasiswa.getId());
            mahasiswaList.add(mahasiswa);
        }
        return mahasiswa;
    }

    public void deleteMahasiswa(Long id) {
        mahasiswaList.removeIf(mahasiswa -> mahasiswa.getId().equals(id));
    }

    public Optional<Mahasiswa> findMahasiswaById(Long id) {
        return mahasiswaList.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
}
package com.example.service;

import com.example.model.Mascotas;
import com.example.repository.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotasService {

    @Autowired
    MascotasRepository mascotasRepository;

    public Mascotas createMascotas(Mascotas mascotas) {
        return mascotasRepository.save(mascotas);
    }

    public List<Mascotas> findAll() {
        return mascotasRepository.findAll();
    }

    public Mascotas findById(Long id) throws Exception {
        return mascotasRepository.findById(id).orElseThrow(() -> new Exception("No existe Actor con " + id));
    }


    public void deleteMascota(Long id) throws Exception {
        Mascotas mascotas = mascotasRepository.findById(id).orElseThrow(() -> new Exception("No existe Actor con " + id));
        mascotasRepository.delete(mascotas);
    }


}

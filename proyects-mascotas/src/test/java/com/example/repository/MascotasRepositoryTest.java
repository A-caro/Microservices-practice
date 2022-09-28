package com.example.repository;

import com.example.model.Mascotas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class MascotasRepositoryTest {

    @Autowired
    MascotasRepository mascotasRepository;


    @Test
    void findById(){
       assertTrue(mascotasRepository.findById(4L).isPresent());
    }
    @Test
    void findAll() {
        List<Mascotas> mascotasList = mascotasRepository.findAll();
        assertTrue(mascotasList.size()>0);
        assertFalse(mascotasRepository.findAll().isEmpty());
    }

    @Test
    void create(){
        Mascotas mascotas = new Mascotas(5L, "Panchito", "Eckl", LocalDate.of(1920,12,12));
        Mascotas mascotasSave = mascotasRepository.save(mascotas);
        assertTrue(mascotasSave.getId()>0);
    }

    @Test
    void update(){
        Mascotas mascotas = mascotasRepository.findById(2L).get();
        mascotas.setName("Potucita");
        Mascotas mascotasUpdate = mascotasRepository.save(mascotas);
        Assertions.assertTrue(mascotasUpdate.getName().equals("Potucita"));
    }

    @Test
    void delete(){
        Mascotas mascotas = mascotasRepository.save(new Mascotas(6l, "Mentito", "Alegre",  LocalDate.of(2000,8,25)));
        mascotasRepository.delete(mascotas);
        assertFalse(mascotasRepository.findById(6L).isPresent());
    }


}
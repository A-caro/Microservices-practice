package com.example.service;

import com.example.model.Mascotas;
import com.example.repository.MascotasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MascotasServiceTest {

    @Mock
    MascotasRepository mascotasRepository;

    @InjectMocks
    MascotasService mascotasService;

    Mascotas mascotas;


    @BeforeEach
    void setUp() {
        mascotas = new Mascotas(1L, "Moli", "Pipa", LocalDate.of(2000, 8, 25));

    }

    @Test
    void createMascotas() {
        Mascotas newMascota = new Mascotas(null, "Chozi", "Kika", LocalDate.now());
        Mascotas createMascota = new Mascotas(7L, "Chozi", "Kika", LocalDate.now());
        when(mascotasRepository.save(newMascota)).thenReturn(createMascota);
        assertNotNull(mascotasService.createMascotas(newMascota));


    }


    @Test
    void findAll() {
        List<Mascotas> mascotasList = new ArrayList<>();
        mascotasList.add(new Mascotas(4L, "Moli", "Pipa", LocalDate.of(2000, 8, 25)));
        mascotasList.add(new Mascotas(7L, "Alegre", "Potus", LocalDate.of(2000, 8, 25)));
        when(mascotasRepository.findAll()).thenReturn(mascotasList);
        assertFalse(mascotasService.findAll().isEmpty());


    }

    @Test
    void findById() throws Exception {
        when(mascotasRepository.findById(1L)).thenReturn(Optional.ofNullable(mascotas));
        assertNotNull(mascotasService.findById(1L));
    }




    @Test
    void deleteMascota() throws Exception {
        Mascotas mascota = new Mascotas(9L, "Moli", "Pipa",  LocalDate.of(2000,8,25));
        System.out.println(mascota);
        when(mascotasRepository.findById(9L)).thenReturn(Optional.empty());
        mascotasRepository.delete(mascota);
        assertFalse(mascotasRepository.findById(mascota.getId()).isPresent());




    }


}
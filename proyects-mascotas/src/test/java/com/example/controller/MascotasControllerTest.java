package com.example.controller;

import com.example.model.Mascotas;
import com.example.repository.MascotasRepository;
import com.example.service.MascotasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class MascotasControllerTest {


    @MockBean
    MascotasService mascotasService;

    @MockBean
    MascotasRepository mascotasRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getMascota() {
    }

    @Test
    void getMascotas() {
    }

    @Test
    void getMascotaById() throws Exception {
        Mascotas mascotas = new Mascotas(6L, "Panchito", "Eckl", LocalDate.of(1920,12,12));
        when(mascotasService.findById(6L)).thenReturn(mascotas);
        mockMvc.perform(MockMvcRequestBuilders.get("/mascotas/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
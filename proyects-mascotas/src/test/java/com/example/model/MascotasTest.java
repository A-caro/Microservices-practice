package com.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MascotasTest {
    Mascotas mascotas;

    @BeforeEach
    void setUp(){
        mascotas = new Mascotas(1L, "Altam", "Potus", LocalDate.of(1958, 12, 12));

    }

    @Test
    void getId() {
        assertEquals(1, mascotas.getId());
    }

    @Test
    void getSurname() {
        assertEquals("Altam" , mascotas.getSurname());
    }

    @Test
    void getName() {
        assertEquals("Potus", mascotas.getName());
    }

    @Test
    void getBirthday() {
        assertEquals(LocalDate.of(1958, 12, 12), mascotas.getBirthday());
    }


    @Test
    void setId() {
        Mascotas mascotas1 = new Mascotas();
        mascotas1.setId(2L);
        assertEquals(2L, mascotas1.getId());
    }

    @Test
    void setSurname() {
        Mascotas mascotas1 = new Mascotas();
        mascotas1.setSurname("Puchito");
        assertEquals("Puchito", mascotas1.getSurname());
    }

    @Test
    void setName() {
        Mascotas mascotas1 = new Mascotas();
        mascotas1.setName("Mento");
        assertEquals("Mento", mascotas1.getName());
    }

    @Test
    void setBirthday() {
        Mascotas mascotas1 = new Mascotas();
        mascotas1.setBirthday(LocalDate.now());
        assertEquals(LocalDate.now(), mascotas1.getBirthday());
    }

}
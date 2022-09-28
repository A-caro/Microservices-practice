package com.example.controller;


import com.example.model.Mascotas;
import com.example.service.MascotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mascotas")
public class MascotasController {

    @Autowired
    MascotasService mascotasService;


    @PostMapping(value ="/create")
    public ResponseEntity<Mascotas> getMascota(@RequestBody Mascotas mascota){
        Mascotas masc = mascotasService.createMascotas(mascota);
        return new ResponseEntity<Mascotas>(masc, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getMascotas(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mascotasService.findAll());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error por favor intente más tarde" + e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMascotaById(@PathVariable("id") Long id) {

        try {
            Mascotas mascota = mascotasService.findById(id);
            return ResponseEntity.ok(mascota);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body( HttpStatus.BAD_REQUEST + "Mascota no encontrada ");
        }
    }



}

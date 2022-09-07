package com.example.client.controller;


import com.example.client.entity.Client;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping
    public ResponseEntity<?> getClient(){
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") Long id){
        try{
            Client client = clientService.getClientById(id);
            return ResponseEntity.ok(client);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST + " No pudimos encontrar al cliente con id " + id);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client addclient = clientService.createClient(client);
        return ResponseEntity.ok(addclient);
    }




}

package com.example.client.controller;


import com.example.client.entity.Client;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/client/{marketId}")
    public ResponseEntity<List<Client>> getClient(@PathVariable("marketId") Long marketId){
        List<Client> clients = clientService.getClient(marketId);
        return ResponseEntity.ok(clients);
    }

}

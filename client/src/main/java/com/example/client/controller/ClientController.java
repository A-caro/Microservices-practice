package com.example.client.controller;


import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;




}

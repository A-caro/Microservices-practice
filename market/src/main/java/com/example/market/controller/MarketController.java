package com.example.market.controller;

import com.example.market.entity.Market;
import com.example.market.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    MarketService marketService;


    @GetMapping("/all")
    public ResponseEntity<List<Market>> findAll(){
        return ResponseEntity.ok(marketService.getAll());
    }

}

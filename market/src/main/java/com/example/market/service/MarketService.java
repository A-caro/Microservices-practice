package com.example.market.service;

import com.example.market.entity.Market;
import com.example.market.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    @Autowired
    MarketRepository marketRepository;

    public List<Market> getAll(){
        return marketRepository.findAll();
    }


}

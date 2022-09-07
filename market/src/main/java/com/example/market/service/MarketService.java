package com.example.market.service;

import ch.qos.logback.core.net.server.Client;
import com.example.market.entity.Market;
import com.example.market.feignclients.ClientFeign;
import com.example.market.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketService {

    @Autowired
    MarketRepository marketRepository;

    @Autowired
    ClientFeign clientFeign;

    public List<Market> getAll(){
        return marketRepository.findAll();
    }

    public Map<String, Object> getClient(Long marketId){
        Map<String, Object> datos = new HashMap<>();
        Market market = marketRepository.findById(marketId).orElse(null);
        datos.put("Market", market);
        List<Client> clients = clientFeign.getClient(marketId);
        datos.put("Client", clients);
        return datos;
    }



}

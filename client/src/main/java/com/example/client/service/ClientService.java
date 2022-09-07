package com.example.client.service;

import com.example.client.entity.Client;
import com.example.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    //metodo que vamos a utilizar para feign
    public List<Client> getClient(Long marketId){
        return clientRepository.findByMarketId(marketId);
    }

}

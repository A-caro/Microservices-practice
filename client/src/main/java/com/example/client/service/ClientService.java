package com.example.client.service;


import com.example.client.entity.Client;
import com.example.client.repository.ClientRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(
                () -> new Exception("No existe cliente con " + id)
        );
    }
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

}

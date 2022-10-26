package com.example.client.service;


import com.example.client.entity.Client;
import com.example.client.feign.InvoiceFeign;
import com.example.client.model.Invoice;
import com.example.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    InvoiceFeign invoiceFeign;

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
    public Map<String, Object> getInvoice(Long clientId) {
        Map<String, Object> invoiceByClient = new HashMap<>();
        Client client = clientRepository.findById(clientId).orElse(null);
        invoiceByClient.put("Client", client);
        List<Invoice> invoices = invoiceFeign.getInvoice(clientId);
        invoiceByClient.put("Invoices", invoices);
        return invoiceByClient;
    }

}

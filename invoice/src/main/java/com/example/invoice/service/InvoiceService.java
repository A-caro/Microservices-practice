package com.example.invoice.service;

import com.example.invoice.entity.Invoice;
import com.example.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public List<Invoice> getAll(){
        return invoiceRepository.findAll();
    }

    public List<Invoice> getInvoice(Long clientId){
        return invoiceRepository.findByClientId(clientId);
    }

}

package com.example.invoice.controller;

import com.example.invoice.entity.Invoice;
import com.example.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<?> getInvoice(){
        return ResponseEntity.ok(invoiceService.getAll());
    }

    @GetMapping("/invoice/{clientId}")
    public ResponseEntity<List<Invoice>> get(@PathVariable("clientId") Long clientId){
        List<Invoice> invoices = invoiceService.getInvoice(clientId);
        return ResponseEntity.ok(invoices);
    }

}

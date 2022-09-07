package com.example.client.feign;

import com.example.client.model.Invoice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "invoice-service", path = "/invoice")
public interface InvoiceFeign {

   @GetMapping("/invoice/{clientId}")
    List<Invoice> getInvoice(@PathVariable("clientId") Long clientId);

}

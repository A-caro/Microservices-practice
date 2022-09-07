package com.example.market.feignclients;

import ch.qos.logback.core.net.server.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "client-service", path = "/client")
public interface ClientFeign {

    @GetMapping("/client/{marketId}")
    List<Client> getClient(@PathVariable("marketId") Long marketId);
}

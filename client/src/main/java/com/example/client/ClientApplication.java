package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ClientApplication {

	public static void main(String[] args) {

		Date now = new Date();
		System.out.println(now);



	}

}

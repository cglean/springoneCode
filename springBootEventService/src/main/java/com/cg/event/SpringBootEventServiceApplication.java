package com.cg.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootEventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEventServiceApplication.class, args);
	}
}

package com.example.eventEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EventEurekaServerApplication {

	static {
		System.out.println("Inside static block for certificate");
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
	}
	public static void main(String[] args) {
		SpringApplication.run(EventEurekaServerApplication.class, args);
	}
}

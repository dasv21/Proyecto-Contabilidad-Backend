package com.msvc.accountant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsvcAccountantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcAccountantApplication.class, args);
	}

}

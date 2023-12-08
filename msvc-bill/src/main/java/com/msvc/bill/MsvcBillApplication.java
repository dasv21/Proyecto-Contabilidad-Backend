package com.msvc.bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsvcBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcBillApplication.class, args);
	}

}

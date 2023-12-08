package com.msvc.bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
public class MsvcBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcBillApplication.class, args);
	}

}

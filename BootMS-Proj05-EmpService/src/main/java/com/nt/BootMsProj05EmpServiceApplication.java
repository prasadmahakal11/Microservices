package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj05EmpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj05EmpServiceApplication.class, args);
	}

}

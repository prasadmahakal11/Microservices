package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class BootMsProj13NetflixZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj13NetflixZuulServerApplication.class, args);
	}

}

package com.boot.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurdekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurdekaServerApplication.class, args);
	}

}

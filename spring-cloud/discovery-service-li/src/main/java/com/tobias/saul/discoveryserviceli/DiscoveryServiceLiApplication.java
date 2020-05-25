package com.tobias.saul.discoveryserviceli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceLiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceLiApplication.class, args);
	}

}

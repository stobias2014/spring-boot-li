package com.tobias.saul.configserverli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerLiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerLiApplication.class, args);
	}

}

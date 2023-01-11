package com.sebashc.centro.vacacional.vuelos.appviajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AppViajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppViajesApplication.class, args);
	}

}

package com.api.web.web_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApiApplication implements CommandLineRunner {

	@Autowired
	private CustomProperty properties;

	public static void main(String[] args) {
		SpringApplication.run(WebApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(properties.getApiUrl());
	}


}

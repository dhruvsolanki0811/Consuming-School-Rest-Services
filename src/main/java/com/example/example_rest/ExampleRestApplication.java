package com.example.example_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.example_rest.proxy")
public class ExampleRestApplication {

	public static void main(String[] args) {


		SpringApplication.run(ExampleRestApplication.class, args);
	}

}

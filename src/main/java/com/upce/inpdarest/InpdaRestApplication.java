package com.upce.inpdarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.upce.mvc")
@SpringBootApplication
public class InpdaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InpdaRestApplication.class, args);
	}
}

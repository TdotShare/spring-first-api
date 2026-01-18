package com.spring.first.api.spring_first_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringFirstApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFirstApiApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        System.out.println("-----------------------------------------");
        System.out.println("http://localhost:8080");
        System.out.println("-----------------------------------------");
    }

}

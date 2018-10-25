package com.moneysupermarket.profilesapitdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProfilesApiTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilesApiTddApplication.class, args);
	}
}

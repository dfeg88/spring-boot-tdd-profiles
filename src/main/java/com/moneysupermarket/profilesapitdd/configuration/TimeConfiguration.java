package com.moneysupermarket.profilesapitdd.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

import static java.time.Clock.systemUTC;

@Configuration
public class TimeConfiguration {

    @Bean
    public Clock clock () {
        return systemUTC();
    }

}

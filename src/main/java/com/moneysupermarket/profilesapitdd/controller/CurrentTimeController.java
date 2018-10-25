package com.moneysupermarket.profilesapitdd.controller;

import com.moneysupermarket.profilesapitdd.model.CurrentTime;
import com.moneysupermarket.profilesapitdd.service.CurrentTimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class CurrentTimeController {

    private CurrentTimeService currentTimeService;

    @GetMapping("/current-times")
    public CurrentTime getCurrentTimes() {
        System.out.println(currentTimeService.getCurrentTimes(ZoneId.of("UTC-7")));
        return currentTimeService.getCurrentTimes(ZoneId.of("UTC-7"));
    }

}

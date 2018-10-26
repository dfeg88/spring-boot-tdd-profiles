package com.moneysupermarket.profilesapitdd.service;

import com.moneysupermarket.profilesapitdd.model.CurrentTime;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Service
public class CurrentTimeService {

    private Clock clock;

    public CurrentTime getCurrentTimes(ZoneId timezone) {
        return new CurrentTime(
                ZonedDateTime.now(clock.withZone(ZoneId.of("UTC+1"))).format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                ZonedDateTime.now(clock.withZone(timezone)).format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        );
    }

    @Scheduled(fixedRate = 180000)
    public void printLocalTimeToConsole() {
        System.out.println(getCurrentTimes(ZoneId.of("UTC-7")).getLocalTime());
    }

}

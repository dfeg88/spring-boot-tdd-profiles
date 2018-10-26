package com.moneysupermarket.profilesapitdd.service;

import com.moneysupermarket.profilesapitdd.model.CurrentTime;
import lombok.AllArgsConstructor;
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
                ZonedDateTime.now(clock).format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                ZonedDateTime.now(clock.withZone(timezone)).format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        );
    }

}

package com.moneysupermarket.profilesapitdd.service;

import com.moneysupermarket.profilesapitdd.model.CurrentTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@ExtendWith({SpringExtension.class, MockitoExtension.class})
class CurrentTimeServiceTest {

    Clock clock;

    private CurrentTimeService currentTimeService;

    private ZoneId canadaTimeZone = ZoneId.of("UTC-7");

    @BeforeEach
    void init() {
        ZoneId utc = ZoneId.of("UTC");
        clock = Clock.fixed(ZonedDateTime.of(2000,1,1,12,0,0,0, utc).toInstant(),utc);
        currentTimeService = new CurrentTimeService(clock);
    }

    @Test
    void test_getCurrentTimes() {
        CurrentTime actual = currentTimeService.getCurrentTimes(canadaTimeZone);
        CurrentTime expected = new CurrentTime("12:00:00", "05:00:00");

        Assertions.assertEquals(actual, expected);

    }

}
package com.moneysupermarket.profilesapitdd.service;

import com.moneysupermarket.profilesapitdd.model.CurrentTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith({SpringExtension.class, MockitoExtension.class})
class CurrentTimeServiceTest {

    private Clock clock;
    private CurrentTimeService underTest;
    private ZoneId canadaTimeZone = ZoneId.of("UTC-7");

    @BeforeEach
    void init() {
        ZoneId utc = ZoneId.of("UTC");
        clock = Clock.fixed(ZonedDateTime.of(2000,1,1,12,0,0,0, utc).toInstant(),utc);
        underTest = new CurrentTimeService(clock);
    }

    @Test
    void test_getCurrentTimes() {
        CurrentTime actual = underTest.getCurrentTimes(canadaTimeZone);
        CurrentTime expected = new CurrentTime("13:00:00", "05:00:00");

        assertEquals(expected, actual);
    }

}
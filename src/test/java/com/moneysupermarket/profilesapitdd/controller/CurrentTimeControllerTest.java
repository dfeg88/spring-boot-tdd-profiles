package com.moneysupermarket.profilesapitdd.controller;

import com.moneysupermarket.profilesapitdd.model.CurrentTime;
import com.moneysupermarket.profilesapitdd.service.CurrentTimeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.ZoneId;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(CurrentTimeController.class)
public class CurrentTimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrentTimeService currentTimeService;

    @BeforeEach
    void setup() {
        ZoneId utc = ZoneId.of("UTC-7");
        when(currentTimeService.getCurrentTimes(utc)).thenReturn(new CurrentTime("12:00:00", "05:00:00"));
    }

    @Test
    void shouldReturnJsonPayloadWith200Status() throws Exception {
        this.mockMvc.perform(get("/current-times"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("localTime", is("12:00:00")))
                .andExpect(jsonPath("canadaTime", is("05:00:00")));
    }
}
package com.moneysupermarket.profilesapitdd.controller;

import com.moneysupermarket.profilesapitdd.model.Address;
import com.moneysupermarket.profilesapitdd.model.Car;
import com.moneysupermarket.profilesapitdd.model.Customer;
import com.moneysupermarket.profilesapitdd.model.Profile;
import com.moneysupermarket.profilesapitdd.service.ProfileService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(ProfileController.class)
class ProfileControllerTest {

    private ProfileController profileController;
    private Profile getProfile;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileService profileService;

    @Mock
    private Profile profile;

    private static final String profileId = "1";

    @BeforeEach
    void init() {
        getProfile = new Profile("", new Customer(), new Address(), new Car());
        profileController = new ProfileController(profileService);
    }

    @AfterEach
    void tearDown() {
        profileController = null;
    }

    @Test
    void shouldCallServiceSaveMethod() {
        profileController.save(profile);
        verify(profileService).save(profile);
    }

    @Test
    void shouldSaveValidProfileWith200Response() throws Exception {
        String profileJson = "{\n"
                + "\"address\":{\n"
                + "\"houseNumber\": \"31\",\n" + "\"street\": \"Street\",\n"
                + "\"town\": \"Manch\",\n" + "\"city\": \"Manch\",\n" + "\"postcode\": \"M24 223\"\n" + "},\n"
                + "\"car\": {\n"
                + "\"registrationNumber\":\"CFM 139W\",\n" + "\"make\": \"BMW\",\n"
                + "\"model\": \"M4\",\n" + "\"engineSize\": \"1\"\n" + "},\n"
                + "\"customer\": {\n"
                + "\"firstName\": \"Dan\",\n" + "\"lastName\": \"Graef\"\n" + "}\n" + "}";

        this.mockMvc.
                perform(post("/profile")
                    .content(profileJson)
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn400ResponseForInvalidProfilePayload() throws Exception {
        String invalidProfileJson = "";

        this.mockMvc.
                perform(post("/profile")
                    .content(invalidProfileJson)
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnProfileWithValidId() throws Exception {
        when(profileService.getById(profileId)).thenReturn(Optional.of(getProfile));

        this.mockMvc
                .perform(get("/profile/" + profileId)
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    void shouldReturn404StatusIfProfileNotFound() throws Exception {
        this.mockMvc
                .perform(get("/profile/" + 2)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
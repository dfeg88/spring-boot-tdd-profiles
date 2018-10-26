package com.moneysupermarket.profilesapitdd.controller;

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

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(ProfileController.class)
class ProfileControllerTest {

    private ProfileController profileController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileService profileService;

    @Mock
    private Profile profile;

    @BeforeEach
    void init() {
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
    public void shouldSaveValidProfileWith200Response() throws Exception {
        final String personDTOJson = "{\n"
                + "    \"address\": {\n"
                + "        \"houseNumber\": \"31\",\n"
                + "        \"street\": \"Street\",\n"
                + "        \"town\": \"Manch\",\n"
                + "        \"city\": \"Manch\",\n"
                + "        \"postcode\": \"M24 223\"\n"
                + "    },\n"
                + "    \"car\": {\n"
                + "        \"registrationNumber\": \"CFM 139W\",\n"
                + "        \"make\": \"BMW\",\n"
                + "        \"model\": \"M4\",\n"
                + "        \"engineSize\": \"1\"\n"
                + "    },\n"
                + "    \"customer\": {\n"
                + "        \"firstName\": \"Dan\",\n"
                + "        \"lastName\": \"Graef\"\n"
                + "    }\n"
                + "}";

        System.out.println(personDTOJson);
        this.mockMvc.
                perform(post("/profile")
                        .content(personDTOJson)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

}
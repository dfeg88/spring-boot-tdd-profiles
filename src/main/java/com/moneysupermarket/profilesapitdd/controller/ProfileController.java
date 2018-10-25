package com.moneysupermarket.profilesapitdd.controller;

import com.moneysupermarket.profilesapitdd.model.Profile;
import com.moneysupermarket.profilesapitdd.model.ProfileResponse;
import com.moneysupermarket.profilesapitdd.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:5000"})
@AllArgsConstructor
@RestController
public class ProfileController {

    private ProfileService profileService;

    @PostMapping(value = "profile")
    public ResponseEntity<ProfileResponse> save(@RequestBody Profile profile) {
        profileService.save(profile);
        return new ResponseEntity<>(ProfileResponse.builder().profileId(profile.getId()).build(), HttpStatus.OK);
    }
}

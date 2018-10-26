package com.moneysupermarket.profilesapitdd.controller;

import com.moneysupermarket.profilesapitdd.model.Profile;
import com.moneysupermarket.profilesapitdd.model.ProfileResponse;
import com.moneysupermarket.profilesapitdd.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:5000"})
@AllArgsConstructor
@RestController
public class ProfileController {

    private ProfileService profileService;

    @PostMapping(value = "/profile")
    public ResponseEntity<ProfileResponse> save(@RequestBody Profile profile) {
        profileService.save(profile);
        return new ResponseEntity<>(ProfileResponse.builder().profileId(profile.getId()).build(), HttpStatus.OK);
    }

    @PutMapping(value = "/profile")
    public ResponseEntity<ProfileResponse> update(@RequestBody Profile profile) {
        profileService.update(profile);
        return new ResponseEntity<>(ProfileResponse.builder().build(), HttpStatus.OK);
    }

    @GetMapping("/profiles")
    public List<Profile> getAll() {
        return profileService.getAll();
    }
}

package com.moneysupermarket.profilesapitdd.service;

import com.moneysupermarket.profilesapitdd.model.Profile;
import com.moneysupermarket.profilesapitdd.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Component
public class ProfileService {

    private ProfileRepository profileRepository;

    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    public Optional<Profile> getById(String id) {
        return profileRepository.findById(id);
    }
}

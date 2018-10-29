package com.moneysupermarket.profilesapitdd.service;

import com.moneysupermarket.profilesapitdd.model.Profile;
import com.moneysupermarket.profilesapitdd.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    public Optional<Profile> getById(String id) {
        return profileRepository.findById(id);
    }

    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    public void update(Profile profile) {
        profileRepository.save(profile);
    }

    public void delete(String id) { profileRepository.deleteById(id); }
}

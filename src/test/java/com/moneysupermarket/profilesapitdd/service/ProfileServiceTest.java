package com.moneysupermarket.profilesapitdd.service;

import com.moneysupermarket.profilesapitdd.model.Profile;
import com.moneysupermarket.profilesapitdd.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
public class ProfileServiceTest {

    private ProfileService underTest;

    @Mock
    private Profile profile;

    @Mock
    private ProfileRepository profileRepository;

    @BeforeEach
    void init() {
        underTest = new ProfileService(profileRepository);
    }

    @Test
    void save_shouldSaveProfile() {
        underTest.save(profile);
        verify(profileRepository).save(profile);
    }

    @Test
    void getById_shouldGetProfileBasedOnId() {
        underTest.getById(anyString());
        verify(profileRepository).findById(anyString());
    }

    @Test
    void getAll_shouldGetAllProfiles() {
        underTest.getAll();
        verify(profileRepository).findAll();
    }

    @Test
    void update_shouldUpdateProfile() {
        underTest.update(profile);
        verify(profileRepository).save(profile);
    }

    @Test
    void delete_verifyThatDeleteMethodIsCalled() {
        underTest.delete(anyString());
        verify(profileRepository).deleteById(anyString());
    }

}

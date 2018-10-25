package com.moneysupermarket.profilesapitdd.repository;

import com.moneysupermarket.profilesapitdd.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
}

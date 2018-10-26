package com.moneysupermarket.profilesapitdd.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Profile {
    @Id
    private String id;

    private Customer customer;
    private Address address;
    private Car car;
}

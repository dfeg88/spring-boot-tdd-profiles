package com.moneysupermarket.profilesapitdd.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Car {

    private String registrationNumber, make, model;
    private double engineSize;

}

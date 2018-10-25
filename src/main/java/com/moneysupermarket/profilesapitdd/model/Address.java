package com.moneysupermarket.profilesapitdd.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {

    private String houseNumber, street, town, city, postcode;

}

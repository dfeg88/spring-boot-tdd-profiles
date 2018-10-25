package com.moneysupermarket.profilesapitdd.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class CurrentTime {
    private String localTime;
    private String canadaTime;
}
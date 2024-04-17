package com.sopt.carrotMarket.domain.address.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class DesireAddress {
    private Address desireAddress;
    private String  desirePlaceName;
}

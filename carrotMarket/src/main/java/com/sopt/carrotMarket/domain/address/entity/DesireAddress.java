package com.sopt.carrotMarket.domain.address.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class DesireAddress {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desire_address_id")
    private Address desireAddress;
    private String  desirePlaceName;
}

package com.sopt.carrotMarket.domain.address.entity;


import com.sopt.carrotMarket.global.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Address extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(nullable = false)
    private String city;   //시

    @Column(nullable = false)
    private String district;  //구

    @Column(nullable = false)
    private String town;    //동

    @Column(nullable = false)
    private Float longitude;

    @Column(nullable = false)
    private Float latitude;
}

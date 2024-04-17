package com.sopt.carrotMarket.domain.item.entity;


import com.sopt.carrotMarket.domain.address.entity.DesireAddress;
import com.sopt.carrotMarket.domain.user.entity.User;
import com.sopt.carrotMarket.global.BaseTimeEntity;
import com.sopt.carrotMarket.global.enums.ItemCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext", nullable = false)
    private String content;

    @Enumerated(STRING)
    @Column(nullable = false)
    private ItemCategory category;

    private long price;

    @Embedded
    private DesireAddress desireAddress;

    private long view;
}








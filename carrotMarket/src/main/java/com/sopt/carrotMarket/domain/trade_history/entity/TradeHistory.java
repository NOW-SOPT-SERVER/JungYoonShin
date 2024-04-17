package com.sopt.carrotMarket.domain.trade_history.entity;


import com.sopt.carrotMarket.domain.item.entity.Item;
import com.sopt.carrotMarket.domain.user.entity.User;
import com.sopt.carrotMarket.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Builder
@AllArgsConstructor(access = PRIVATE)
public class TradeHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "trade_history_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;
}

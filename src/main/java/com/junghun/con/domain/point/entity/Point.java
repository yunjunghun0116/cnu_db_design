package com.junghun.con.domain.point.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "point")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "point")
    private int point;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "received_date")
    private LocalDateTime receivedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expired_date")
    private LocalDateTime expiredDate;

    @Builder.Default
    @Column(name = "min_order_price")
    private int minOrderPrice = 10000;

    @Builder.Default
    @Column(name = "is_used")
    private boolean isUsed = false;
}
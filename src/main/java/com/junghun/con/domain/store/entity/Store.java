package com.junghun.con.domain.store.entity;

import com.junghun.con.domain.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "open_hour")
    private int openHour;

    @Column(name = "close_hour")
    private int closeHour;

    @Builder.Default
    @Column(name = "is_rest_holiday")
    private boolean isRestHoliday = false;
}
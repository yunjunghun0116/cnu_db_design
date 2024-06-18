package com.junghun.con.domain.order.entity;

import com.junghun.con.domain.store.entity.Store;
import com.junghun.con.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @Builder.Default
    @Column(name = "total_price")
    private int totalPrice = 0;

    @Column(name = "order_date")
    private LocalDateTime orderDate;
}
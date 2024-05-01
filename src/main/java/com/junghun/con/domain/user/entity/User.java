package com.junghun.con.domain.user.entity;

import com.junghun.con.domain.basket.entity.BasketMenu;
import com.junghun.con.domain.like.entity.LikeStore;
import com.junghun.con.domain.order.entity.Order;
import com.junghun.con.domain.point.entity.Point;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "phone", length = 30)
    private String phone;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Point> pointList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BasketMenu> basketMenuList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeStore> likeStoreList = new ArrayList<>();
}
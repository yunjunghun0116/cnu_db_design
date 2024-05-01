package com.junghun.con.domain.store.entity;

import com.junghun.con.domain.basket.entity.BasketMenu;
import com.junghun.con.domain.like.entity.LikeStore;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.order.entity.OrderMenu;
import com.junghun.con.domain.point.entity.Point;
import com.junghun.con.domain.user.entity.User;
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

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private StoreAddress address;

    @Column(name = "open_time")
    private LocalTime openTime;

    @Column(name = "close_time")
    private LocalTime closeTime;

    @Builder.Default
    @Column(name = "is_rest_holiday")
    private boolean isRestHoliday = false;

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menuList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BasketMenu> basketMenuList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderMenu> orderMenuList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeStore> likeStoreList = new ArrayList<>();
}
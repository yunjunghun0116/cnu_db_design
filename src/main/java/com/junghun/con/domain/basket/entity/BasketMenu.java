package com.junghun.con.domain.basket.entity;

import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.point.entity.Point;
import com.junghun.con.domain.store.entity.Store;
import com.junghun.con.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "basket_menu")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BasketMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @Builder.Default
    @Column(name = "count")
    private int count = 0;
}
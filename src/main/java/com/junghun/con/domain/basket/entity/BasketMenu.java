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

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "menu_id")
    private Long menuId;

    @Builder.Default
    @Column(name = "count")
    private int count = 0;
}
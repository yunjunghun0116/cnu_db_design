package com.junghun.con.domain.order.entity;

import com.junghun.con.domain.menu.entity.Menu;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_menu")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @Builder.Default
    @Column(name = "count")
    private int count = 0;
}
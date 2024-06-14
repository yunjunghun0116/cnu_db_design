package com.junghun.con.domain.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "store_address")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "middle_place", length = 50)
    private String middlePlace;

    @Column(name = "detail_place", length = 100)
    private String detailPlace;
}
package com.junghun.con.domain.basket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketDto {
    private Long userId;
    private Long storeId;
    private Long menuId;
    private int count;
}
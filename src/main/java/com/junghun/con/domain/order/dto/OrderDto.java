package com.junghun.con.domain.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Long userId;
    private Long storeId;
    private int totalPrice;
}
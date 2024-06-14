package com.junghun.con.domain.store.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class StoreAddressDto {
    private Long storeId;
    private String city;
    private String middlePlace;
    private String detailPlace;
}
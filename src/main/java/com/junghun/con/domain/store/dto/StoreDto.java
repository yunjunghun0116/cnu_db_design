package com.junghun.con.domain.store.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class StoreDto {
    private String name;
    private String city;
    private String middlePlace;
    private String detailPlace;
    private LocalTime openTime;
    private LocalTime closeTime;
    private boolean isRestHoliday;
}
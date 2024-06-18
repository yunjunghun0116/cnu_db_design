package com.junghun.con.domain.store.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StoreDto {
    private String name;
    private String city;
    private String middlePlace;
    private String detailPlace;
    private int openHour;
    private int closeHour;
    private boolean restHoliday;
}
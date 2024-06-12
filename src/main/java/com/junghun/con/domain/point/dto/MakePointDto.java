package com.junghun.con.domain.point.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakePointDto {
    Long userId;
    int point;
    int minOrderPrice;
}

package com.junghun.con.domain.menu.dto;

import com.junghun.con.domain.menu.entity.Menu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private Long menuId;
    private String name;
}
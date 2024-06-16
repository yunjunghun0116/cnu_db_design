package com.junghun.con.domain.menu.service;

import com.junghun.con.domain.menu.dto.MenuDto;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository repository;

    public Menu addMenu(MenuDto menuDto){
        Menu menu = Menu.builder()
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .build();

        return repository.save(menu);
    }


}

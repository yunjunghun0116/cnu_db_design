package com.junghun.con.domain.menu.service;

import com.junghun.con.domain.menu.dto.MenuDto;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository repository;

    public Menu addMenu(MenuDto menuDto) {
        Menu menu = Menu.builder()
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .build();

        return repository.save(menu);
    }

    public List<Menu> findAllMenu() {
        return repository.findAll();
    }

    public List<Menu> findByPrice(int minPrice, int maxPrice) {
        return repository.findByPrice(minPrice, maxPrice);
    }

    public List<Menu> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Menu> findByNameAndPrice(String name, int minPrice, int maxPrice) {
        return repository.findByNameAndPrice(name, minPrice, maxPrice);
    }


}

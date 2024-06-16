package com.junghun.con.domain.menu.controller;

import com.junghun.con.domain.menu.dto.MenuDto;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService service;

    @PutMapping("/add")
    public ResponseEntity<Menu> addMenu(@RequestBody MenuDto menuDto) {
        Menu menu = service.addMenu(menuDto);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Menu>> findByQuery(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "minPrice", required = false) Integer minPrice,
            @RequestParam(value = "maxPrice", required = false) Integer maxPrice
    ) {
        List<Menu> menuList;
        if (name == null && minPrice == null && maxPrice == null) {
            menuList = service.findAllMenu();
            return new ResponseEntity<>(menuList, HttpStatus.OK);
        }
        if (minPrice == null || maxPrice == null) {
            menuList = service.findByName(name);
            return new ResponseEntity<>(menuList, HttpStatus.OK);
        }
        if (name == null) {
            menuList = service.findByPrice(minPrice, maxPrice);
            return new ResponseEntity<>(menuList, HttpStatus.OK);
        }
        menuList = service.findByNameAndPrice(name, minPrice, maxPrice);
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }


}

package com.junghun.con.domain.menu.controller;

import com.junghun.con.domain.menu.dto.MenuDto;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
}

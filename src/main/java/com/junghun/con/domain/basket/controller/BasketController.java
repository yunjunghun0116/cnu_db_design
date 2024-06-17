package com.junghun.con.domain.basket.controller;

import com.junghun.con.domain.basket.dto.BasketDto;
import com.junghun.con.domain.basket.entity.BasketMenu;
import com.junghun.con.domain.basket.service.BasketService;
import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;

    @PutMapping("/add")
    public ResponseEntity<BasketMenu> addBasketMenu(@RequestBody BasketDto basketDto) {
        BasketMenu basketMenu = service.addBasketMenu(basketDto);
        return new ResponseEntity<>(basketMenu, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasketMenu(@PathVariable Long id) {
        service.deleteBasketMenu(id);
        return ResponseEntity.ok().build();
    }
}

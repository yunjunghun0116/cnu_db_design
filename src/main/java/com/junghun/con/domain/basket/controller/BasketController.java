package com.junghun.con.domain.basket.controller;

import com.junghun.con.domain.basket.dto.BasketDto;
import com.junghun.con.domain.basket.entity.BasketMenu;
import com.junghun.con.domain.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<BasketMenu>> getAllByUserId(@RequestParam Long userId) {
        List<BasketMenu> basketMenuList = service.getAllByUserId(userId);
        return new ResponseEntity<>(basketMenuList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasketMenu(@PathVariable Long id) {
        service.deleteBasketMenu(id);
        return ResponseEntity.ok().build();
    }
}

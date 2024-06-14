package com.junghun.con.domain.store.controller;

import com.junghun.con.domain.store.dto.StoreDto;
import com.junghun.con.domain.store.entity.Store;
import com.junghun.con.domain.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;

    @PutMapping("/open")
    public ResponseEntity<Store> openStore(@RequestBody StoreDto storeDto) {
        Store store = service.openStore(storeDto);
        return new ResponseEntity<>(store, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Store>> getAllStore() {
        List<Store> storeList = service.getAllStore();
        return new ResponseEntity<>(storeList, HttpStatus.OK);
    }

}

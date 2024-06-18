package com.junghun.con.domain.order.controller;

import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.order.dto.OrderDto;
import com.junghun.con.domain.order.entity.Order;
import com.junghun.con.domain.order.service.OrderService;
import com.junghun.con.domain.point.entity.Point;
import com.junghun.con.domain.store.dto.StoreDto;
import com.junghun.con.domain.store.entity.Store;
import com.junghun.con.domain.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PutMapping
    public ResponseEntity<Order> order(@RequestBody OrderDto orderDto) {
        Order order = service.order(orderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Order>> getUserHistoryAll(@RequestParam Long userId) {
        List<Order> orderList = service.getUserHistoryAll(userId);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/history/date")
    public ResponseEntity<List<Order>> getUserHistoryWithDate(@RequestParam Long userId,@RequestParam String startDate, @RequestParam String endDate) {
        List<Order> orderList = service.getUserHistoryWithDate(userId,startDate,endDate);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/maxSoldMenu")
    public ResponseEntity<Menu> getMaxSoldMenu() {
        Menu menu = service.getMaxSoldMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @GetMapping("/maxSoldStore")
    public ResponseEntity<Store> getMaxSoldStore() {
        Store store = service.getMaxSoldStore();
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
}

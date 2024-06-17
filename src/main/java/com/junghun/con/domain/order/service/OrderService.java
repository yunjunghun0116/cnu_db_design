package com.junghun.con.domain.order.service;

import com.junghun.con.domain.basket.entity.BasketMenu;
import com.junghun.con.domain.basket.repository.BasketMenuRepository;
import com.junghun.con.domain.order.dto.OrderDto;
import com.junghun.con.domain.order.entity.Order;
import com.junghun.con.domain.order.entity.OrderMenu;
import com.junghun.con.domain.order.repository.OrderMenuRepository;
import com.junghun.con.domain.order.repository.OrderRepository;
import com.junghun.con.domain.store.entity.Store;
import com.junghun.con.domain.store.exception.NotFoundStoreException;
import com.junghun.con.domain.store.repository.StoreRepository;
import com.junghun.con.domain.user.entity.User;
import com.junghun.con.domain.user.exception.NotFoundUserException;
import com.junghun.con.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final BasketMenuRepository basketMenuRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public Order order(OrderDto orderDto){
        List<BasketMenu> allBasketMenu = getAllBasketMenu(orderDto.getUserId());

        User user = userRepository.findById(orderDto.getUserId()).orElseThrow(() -> new NotFoundUserException("해당 id를 가진 유저가 존재하지 않습니다."));
        Store store = storeRepository.findById(orderDto.getStoreId()).orElseThrow(() -> new NotFoundStoreException("해당 id를 가진 음식점이 존재하지 않습니다."));


        Order order = Order.builder()
                .user(user)
                .store(store)
                .totalPrice(orderDto.getTotalPrice())
                .orderDate(LocalDateTime.now())
                .build();

        Order savedOrder = repository.save(order);

        for(BasketMenu menu : allBasketMenu){
            OrderMenu orderMenu = OrderMenu.builder()
                    .order(savedOrder)
                    .menu(menu.getMenu())
                    .count(menu.getCount())
                    .build();

            orderMenuRepository.save(orderMenu);
        }

        return savedOrder;
    }

    public List<BasketMenu> getAllBasketMenu(Long userId) {
        return basketMenuRepository.findAllByUserId(userId);
    }

}
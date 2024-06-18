package com.junghun.con.domain.basket.service;

import com.junghun.con.domain.basket.dto.BasketDto;
import com.junghun.con.domain.basket.entity.BasketMenu;
import com.junghun.con.domain.basket.repository.BasketMenuRepository;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.menu.exception.NotFoundMenuException;
import com.junghun.con.domain.menu.repository.MenuRepository;
import com.junghun.con.domain.store.entity.Store;
import com.junghun.con.domain.store.exception.NotFoundStoreException;
import com.junghun.con.domain.store.repository.StoreRepository;
import com.junghun.con.domain.user.entity.User;
import com.junghun.con.domain.user.exception.NotFoundUserException;
import com.junghun.con.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketMenuRepository repository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    public BasketMenu addBasketMenu(BasketDto basketDto) {

        Menu menu = menuRepository.findById(basketDto.getMenuId()).orElseThrow(() -> new NotFoundMenuException("해당 id를 가진 메뉴가 존재하지 않습니다."));
        User user = userRepository.findById(basketDto.getUserId()).orElseThrow(() -> new NotFoundUserException("해당 id를 가진 유저가 존재하지 않습니다."));
        Store store = storeRepository.findById(basketDto.getStoreId()).orElseThrow(() -> new NotFoundStoreException("해당 id를 가진 음식점이 존재하지 않습니다."));

        List<BasketMenu> basketMenuList = getAllByUserId(basketDto.getUserId());
        for(BasketMenu basketMenu : basketMenuList){
            if(Objects.equals(basketMenu.getStore().getId(), store.getId())) continue;
            deleteBasketMenu(basketMenu.getId());
        }

        BasketMenu basketMenu = BasketMenu.builder()
                .menu(menu)
                .user(user)
                .store(store)
                .count(basketDto.getCount())
                .build();

        return repository.save(basketMenu);
    }

    public List<BasketMenu> getAllByUserId(Long userId) {

        return repository.findAllByUserId(userId);
    }

    public void deleteBasketMenu(Long id) {
        repository.deleteById(id);
    }
}

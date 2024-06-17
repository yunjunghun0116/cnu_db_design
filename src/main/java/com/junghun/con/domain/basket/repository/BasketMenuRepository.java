package com.junghun.con.domain.basket.repository;

import com.junghun.con.domain.basket.entity.BasketMenu;
import com.junghun.con.domain.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketMenuRepository extends JpaRepository<BasketMenu, Long> {
    List<BasketMenu> findAllByUserId(Long userId);
}

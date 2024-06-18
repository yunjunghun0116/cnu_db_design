package com.junghun.con.domain.order.repository;

import com.junghun.con.domain.order.entity.Order;
import com.junghun.con.domain.order.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long> {

    @Query(value = "SELECT om.menu_id FROM order_menu om GROUP BY om.menu_id ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
    Long getMaxSoldMenuId();
}

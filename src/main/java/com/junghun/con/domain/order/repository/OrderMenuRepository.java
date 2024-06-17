package com.junghun.con.domain.order.repository;

import com.junghun.con.domain.order.entity.Order;
import com.junghun.con.domain.order.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long> {
}

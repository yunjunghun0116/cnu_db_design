package com.junghun.con.domain.order.repository;

import com.junghun.con.domain.order.entity.Order;
import com.junghun.con.domain.point.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.user.id = :userId")
    List<Order> getUserHistoryAll(Long userId);

    @Query(value = "SELECT * FROM orders WHERE user_id = :userId AND  order_date > :startDate AND order_date < :endDate", nativeQuery = true)
    List<Order> getUserHistoryWithDate(Long userId, String startDate, String endDate);
}

package com.junghun.con.domain.point.repository;

import com.junghun.con.domain.point.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    @Query(value = "SELECT * FROM point WHERE expired_date > now() AND user_id = :userId AND is_used = false",nativeQuery = true)
    List<Point> findByUserCanUsePoint(Long userId);
}

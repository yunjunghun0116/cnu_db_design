package com.junghun.con.domain.like.repository;

import com.junghun.con.domain.like.dto.LikeStoreDto;
import com.junghun.con.domain.like.entity.LikeStore;
import com.junghun.con.domain.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeStoreRepository extends JpaRepository<LikeStore, Long> {

    @Query("SELECT l FROM LikeStore l WHERE l.store.id = :storeId AND l.user.id = :userId")
    List<LikeStore> isLike(Long storeId, Long userId);
}

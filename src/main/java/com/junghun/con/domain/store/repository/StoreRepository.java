package com.junghun.con.domain.store.repository;

import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("SELECT s FROM Store s JOIN LikeStore ls ON s.id = ls.store.id WHERE ls.user.id = :userId")
    List<Store> findLikeStore(Long userId);
}

package com.junghun.con.domain.menu.repository;

import com.junghun.con.domain.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT m FROM Menu m WHERE m.price >= :minPrice AND m.price <= :maxPrice")
    List<Menu> findByPrice(int minPrice, int maxPrice);

    @Query("SELECT m FROM Menu m WHERE m.name LIKE %:name%")
    List<Menu> findByName(String name);

    @Query("SELECT m FROM Menu m WHERE m.name LIKE %:name% AND m.price >= :minPrice AND m.price <= :maxPrice")
    List<Menu> findByNameAndPrice(String name, int minPrice, int maxPrice);

    @Query("SELECT m FROM Menu m "+
    "JOIN Category c ON c.menuId = m.id "+
    "WHERE c.name = :category")
    List<Menu> findByCategory(String category);
}

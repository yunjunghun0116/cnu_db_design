package com.junghun.con.domain.menu.repository;

import com.junghun.con.domain.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.name = :categoryName AND c.menu.id = :menuId")
    List<Category> findDuplicatedCategoryName(Long menuId, String categoryName);

    @Query("SELECT c FROM Category c WHERE c.menu.id = :menuId")
    List<Category> getMenuCategory(Long menuId);

}

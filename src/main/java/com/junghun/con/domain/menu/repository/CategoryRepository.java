package com.junghun.con.domain.menu.repository;

import com.junghun.con.domain.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM CATEGORY WHERE menu_id IN " +
            "(SELECT DISTINCT menu_id FROM CATEGORY WHERE name = :categoryName)"
            , nativeQuery = true)
    List<Category> findByCategoryName(String categoryName);

}

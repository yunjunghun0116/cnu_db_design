package com.junghun.con.domain.menu.service;

import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Category addCategory(CategoryDto categoryDto) {
        Category category = Category.builder()
                .menuId(categoryDto.getMenuId())
                .name(categoryDto.getName())
                .build();

        return repository.save(category);
    }

    public List<Category> findByCategoryName(String categoryName) {
        return repository.findByCategoryName(categoryName);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}

package com.junghun.con.domain.menu.service;

import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public void addCategory(CategoryDto categoryDto){
        Category category = Category.builder()
                .menu(categoryDto.getMenu())
                .name(categoryDto.getName())
                .build();

        repository.save(category);
    }


}

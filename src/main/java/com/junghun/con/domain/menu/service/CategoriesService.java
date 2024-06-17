package com.junghun.con.domain.menu.service;

import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.menu.exception.DuplicatedCategoryException;
import com.junghun.con.domain.menu.exception.NotFoundMenuException;
import com.junghun.con.domain.menu.repository.CategoriesRepository;
import com.junghun.con.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    private final CategoriesRepository repository;
    private final MenuRepository menuRepository;

    public Category addCategory(CategoryDto categoryDto) {

        List<Category> categoryList = repository.findDuplicatedCategoryName(categoryDto.getMenuId(), categoryDto.getName());
        if (!categoryList.isEmpty()) {
            throw new DuplicatedCategoryException("이미 해당 메뉴에는 같은 이름을 갖고 있는 카테고리가 존재합니다.");
        }

        Menu menu = menuRepository.findById(categoryDto.getMenuId()).orElseThrow(() -> new NotFoundMenuException("해당 id를 가진 메뉴가 존재하지 않습니다."));

        Category category = Category.builder()
                .menu(menu)
                .name(categoryDto.getName())
                .build();

        return repository.save(category);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}

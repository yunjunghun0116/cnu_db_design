package com.junghun.con.domain.menu.controller;

import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoriesService service;

    @PutMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = service.addCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}

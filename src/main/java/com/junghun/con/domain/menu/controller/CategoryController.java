package com.junghun.con.domain.menu.controller;

import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PutMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = service.addCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<List<Category>> getMenuCategory(@PathVariable Long id) {
        List<Category> categoryList = service.getMenuCategory(id);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}

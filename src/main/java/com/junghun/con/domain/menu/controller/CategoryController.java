package com.junghun.con.domain.menu.controller;

import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.dto.MenuDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.menu.service.CategoryService;
import com.junghun.con.domain.menu.service.MenuService;
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

    @GetMapping("/find")
    public ResponseEntity<List<Category>> findByCategoryName(@RequestParam String categoryName) {
        List<Category> categoryList = service.findByCategoryName(categoryName);
        return new ResponseEntity<>(categoryList, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
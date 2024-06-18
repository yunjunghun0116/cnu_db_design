package com.junghun.con.domain.like.controller;

import com.junghun.con.domain.like.dto.LikeStoreDto;
import com.junghun.con.domain.like.service.LikeStoreService;
import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
public class LikeStoreController {

    private final LikeStoreService service;

    @PutMapping
    public ResponseEntity<Void> like(@RequestBody LikeStoreDto likeStoreDto) {
        service.like(likeStoreDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/isLike")
    public ResponseEntity<Boolean> isLike(@RequestBody LikeStoreDto likeStoreDto) {
        boolean isLike = service.isLike(likeStoreDto);
        return new ResponseEntity<>(isLike, HttpStatus.OK);
    }

    @PostMapping("/dislike")
    public ResponseEntity<Void> dislike(@RequestBody LikeStoreDto likeStoreDto) {
        service.dislike(likeStoreDto);
        return ResponseEntity.ok().build();
    }
}

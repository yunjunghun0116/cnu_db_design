package com.junghun.con.domain.like.service;

import com.junghun.con.domain.like.dto.LikeStoreDto;
import com.junghun.con.domain.like.entity.LikeStore;
import com.junghun.con.domain.like.repository.LikeStoreRepository;
import com.junghun.con.domain.menu.dto.CategoryDto;
import com.junghun.con.domain.menu.entity.Category;
import com.junghun.con.domain.menu.entity.Menu;
import com.junghun.con.domain.menu.exception.DuplicatedCategoryException;
import com.junghun.con.domain.menu.exception.NotFoundMenuException;
import com.junghun.con.domain.menu.repository.CategoryRepository;
import com.junghun.con.domain.menu.repository.MenuRepository;
import com.junghun.con.domain.store.entity.Store;
import com.junghun.con.domain.store.exception.NotFoundStoreException;
import com.junghun.con.domain.store.repository.StoreRepository;
import com.junghun.con.domain.user.entity.User;
import com.junghun.con.domain.user.exception.NotFoundUserException;
import com.junghun.con.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeStoreService {

    private final LikeStoreRepository repository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    public void like(LikeStoreDto likeStoreDto) {
        Store store = storeRepository.findById(likeStoreDto.getStoreId()).orElseThrow(() -> new NotFoundStoreException("해당 id를 가진 음식점이 존재하지 않습니다."));
        User user = userRepository.findById(likeStoreDto.getUserId()).orElseThrow(()->new NotFoundUserException("해당 id를 가진 유저가 없습니다."));

        LikeStore likeStore = LikeStore.builder()
                .store(store)
                .user(user)
                .build();

        repository.save(likeStore);
    }


    public boolean isLike(LikeStoreDto likeStoreDto) {
        List<LikeStore> result = repository.isLike(likeStoreDto.getStoreId(), likeStoreDto.getUserId());
        return !result.isEmpty();
    }
    public void dislike(LikeStoreDto likeStoreDto) {
        List<LikeStore> result = repository.isLike(likeStoreDto.getStoreId(), likeStoreDto.getUserId());
        for(LikeStore likeStore : result){
            repository.deleteById(likeStore.getId());
        }
    }
}

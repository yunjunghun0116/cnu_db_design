package com.junghun.con.domain.store.service;

import com.junghun.con.domain.store.dto.StoreDto;
import com.junghun.con.domain.store.entity.Store;
import com.junghun.con.domain.store.entity.StoreAddress;
import com.junghun.con.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repository;

    public Store openStore(StoreDto storeDto){
        Store store = Store.builder()
                .name(storeDto.getName())
                .openTime(storeDto.getOpenTime())
                .closeTime(storeDto.getCloseTime())
                .isRestHoliday(storeDto.isRestHoliday())
                .build();

        Store savedStore = repository.save(store);

        StoreAddress storeAddress = StoreAddress.builder()
                .storeId(savedStore.getId())
                .city(storeDto.getCity())
                .middlePlace(storeDto.getMiddlePlace())
                .detailPlace(storeDto.getDetailPlace())
                .build();

        return savedStore;
    }
}

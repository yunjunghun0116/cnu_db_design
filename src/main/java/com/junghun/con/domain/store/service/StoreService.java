package com.junghun.con.domain.store.service;

import com.junghun.con.domain.store.dto.StoreAddressDto;
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

    private final StoreAddressService addressService;

    public Store openStore(StoreDto storeDto){
        Store store = Store.builder()
                .name(storeDto.getName())
                .openTime(storeDto.getOpenTime())
                .closeTime(storeDto.getCloseTime())
                .isRestHoliday(storeDto.isRestHoliday())
                .build();

        Store savedStore = repository.save(store);

        StoreAddressDto storeAddressDto = new StoreAddressDto();
        storeAddressDto.setStoreId(savedStore.getId());
        storeAddressDto.setCity(storeDto.getCity());
        storeAddressDto.setMiddlePlace(storeDto.getMiddlePlace());
        storeAddressDto.setDetailPlace(storeDto.getDetailPlace());

        addressService.makeStoreAddress(storeAddressDto);

        return savedStore;
    }
}

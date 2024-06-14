package com.junghun.con.domain.store.service;

import com.junghun.con.domain.store.dto.StoreAddressDto;
import com.junghun.con.domain.store.dto.StoreDto;
import com.junghun.con.domain.store.entity.StoreAddress;
import com.junghun.con.domain.store.repository.StoreAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreAddressService {

    private final StoreAddressRepository repository;

    public void makeStoreAddress(StoreAddressDto storeAddressDto){
        StoreAddress storeAddress = StoreAddress.builder()
                .storeId(storeAddressDto.getStoreId())
                .city(storeAddressDto.getCity())
                .middlePlace(storeAddressDto.getMiddlePlace())
                .detailPlace(storeAddressDto.getDetailPlace())
                .build();

        repository.save(storeAddress);
    }


}

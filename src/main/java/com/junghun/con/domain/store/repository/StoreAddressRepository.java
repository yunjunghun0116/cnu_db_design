package com.junghun.con.domain.store.repository;

import com.junghun.con.domain.store.entity.StoreAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAddressRepository extends JpaRepository<StoreAddress, Long> {

}

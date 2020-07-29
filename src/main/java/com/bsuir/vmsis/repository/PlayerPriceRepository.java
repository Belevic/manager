package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.PlayerPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerPriceRepository extends CrudRepository<PlayerPrice,Long> {
}
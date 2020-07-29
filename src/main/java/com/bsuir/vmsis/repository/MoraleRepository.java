package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Health;
import com.bsuir.vmsis.model.impl.Morale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoraleRepository extends CrudRepository<Morale,Long> {
    Morale findByPlayerMoraleId(Long id);
}

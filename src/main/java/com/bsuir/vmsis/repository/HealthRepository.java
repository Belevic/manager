package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Health;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends CrudRepository<Health,Long> {
    Health findByPlayerHealthId(Long id);
}

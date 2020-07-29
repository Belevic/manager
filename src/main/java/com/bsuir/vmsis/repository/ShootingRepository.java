package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Shooting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShootingRepository extends CrudRepository<Shooting,Long> {
    Shooting findByPlayerShootingId(Long id);
}

package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Physical;
import com.bsuir.vmsis.model.impl.Shooting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalRepository extends CrudRepository<Physical,Long> {
    Physical findByPlayerPhysicalId(Long id);
}

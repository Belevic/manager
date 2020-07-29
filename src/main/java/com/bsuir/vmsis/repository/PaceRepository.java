package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Pace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaceRepository extends CrudRepository<Pace,Long> {
    Pace findByPlayerPaceId(Long id);
}

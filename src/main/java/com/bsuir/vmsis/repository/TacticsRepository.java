package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Tactics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacticsRepository extends CrudRepository<Tactics,Long> {
    Tactics findByTeamTacticsId(Long id);
}

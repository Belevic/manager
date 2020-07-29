package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Squad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends CrudRepository<Squad,Long> {
    Squad findByTeamId(Long id);
}

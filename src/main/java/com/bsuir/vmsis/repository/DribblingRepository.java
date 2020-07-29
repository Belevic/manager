package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Dribbling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DribblingRepository extends CrudRepository<Dribbling,Long> {
    Dribbling findByPlayerDribblingId(Long id);
}

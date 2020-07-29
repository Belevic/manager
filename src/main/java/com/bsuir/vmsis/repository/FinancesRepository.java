package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Finances;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancesRepository extends CrudRepository<Finances,Long> {
    Finances findByTeamFinancesId(Long id);
}

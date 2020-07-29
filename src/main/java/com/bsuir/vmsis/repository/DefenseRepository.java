package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Defense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenseRepository extends CrudRepository<Defense,Long> {
    Defense findByPlayerDefenseId(Long id);
}

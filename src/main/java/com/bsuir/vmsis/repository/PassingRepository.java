package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Passing;
import com.bsuir.vmsis.model.impl.Shooting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassingRepository extends CrudRepository<Passing,Long> {
    Passing findByPlayerPassingId(Long id);
}
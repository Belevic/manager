package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Referee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeRepository extends CrudRepository<Referee,Long> {
}

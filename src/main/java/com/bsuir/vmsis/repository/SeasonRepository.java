package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends CrudRepository<Season,Long> {
}

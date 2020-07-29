package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.LineUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineUpRepository extends CrudRepository<LineUp,Long> {
    LineUp findByTeamLineUpId(Long id);
}

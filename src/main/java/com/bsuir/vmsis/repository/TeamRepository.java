package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.dto.impl.TeamDto;
import com.bsuir.vmsis.model.impl.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
    Team findByName(String name);
    List<Team> findByLeagueId(Long id);
    Team findByManagerId(Long managerId);
}

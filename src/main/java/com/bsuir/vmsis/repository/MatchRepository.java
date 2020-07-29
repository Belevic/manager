package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {
    Match findByHomeTeamIdAndFixtureId(Long homeTeamId,Long fixtureId);
    List<Match> findByFixtureId(Long fixtureId);
}

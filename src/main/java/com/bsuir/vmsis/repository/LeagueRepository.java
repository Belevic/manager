package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends CrudRepository<League, Long> {
    League findByName(String name);
    List<League> findByCountryName(String countryName);
}

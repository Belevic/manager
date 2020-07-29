package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {
    Country findByName(String name);
    Country findByAbbreviation(String abbreviation);
}

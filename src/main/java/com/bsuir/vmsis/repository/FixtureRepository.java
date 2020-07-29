package com.bsuir.vmsis.repository;


import com.bsuir.vmsis.model.impl.Fixture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixtureRepository extends CrudRepository<Fixture,Long> {
}

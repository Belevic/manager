package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.MatchStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchStatisticsRepository extends CrudRepository<MatchStatistics,Long> {
    List<MatchStatistics> findByMatchStatisticsId(Long id);
}

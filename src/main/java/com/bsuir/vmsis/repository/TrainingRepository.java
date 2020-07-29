package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<Training,Long> {
    Training findByTeamTrainingId(Long id);
}
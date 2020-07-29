package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.TrainingDto;
import com.bsuir.vmsis.mapper.impl.TrainingMapper;
import com.bsuir.vmsis.model.impl.Training;
import com.bsuir.vmsis.repository.TrainingRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingService implements EntityService<TrainingDto> {

    @Autowired
    private TrainingRepository repository;

    @Autowired
    private TrainingMapper mapper;

    public TrainingService(TrainingRepository repository, TrainingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TrainingDto create(TrainingDto entity){
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }
    @Override
    public TrainingDto update(TrainingDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TrainingDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<TrainingDto> getEntities() {
        List<Training> result = new ArrayList<Training>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }

    public TrainingDto getByTeamId(Long id) {
        return mapper.toDto(repository.findByTeamTrainingId(id));
    }
}

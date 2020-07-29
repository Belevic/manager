package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.TacticsDto;
import com.bsuir.vmsis.mapper.impl.TacticsMapper;
import com.bsuir.vmsis.model.impl.Tactics;
import com.bsuir.vmsis.repository.TacticsRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TacticsService implements EntityService<TacticsDto> {

    @Autowired
    private TacticsRepository repository;

    @Autowired
    private TacticsMapper mapper;

    public TacticsService(TacticsRepository repository, TacticsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TacticsDto create(TacticsDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public TacticsDto update(TacticsDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TacticsDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<TacticsDto> getEntities(){
        List<Tactics> result = new ArrayList<Tactics>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }

    public TacticsDto getByTeamId(Long id){
        return mapper.toDto(repository.findByTeamTacticsId(id));
    }
}


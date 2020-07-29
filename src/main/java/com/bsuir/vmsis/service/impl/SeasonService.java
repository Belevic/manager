package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.SeasonDto;
import com.bsuir.vmsis.mapper.impl.SeasonMapper;
import com.bsuir.vmsis.model.impl.Season;
import com.bsuir.vmsis.repository.SeasonRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonService implements EntityService<SeasonDto> {

    @Autowired
    private SeasonRepository repository;

    @Autowired
    private SeasonMapper mapper;

    public SeasonService(SeasonRepository repository, SeasonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SeasonDto create(SeasonDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public SeasonDto update(SeasonDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public SeasonDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<SeasonDto> getEntities() {
        List<Season> result = new ArrayList<Season>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }
}

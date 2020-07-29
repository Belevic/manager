package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.FinancesDto;
import com.bsuir.vmsis.mapper.impl.FinancesMapper;
import com.bsuir.vmsis.model.impl.Finances;
import com.bsuir.vmsis.model.impl.Fixture;
import com.bsuir.vmsis.repository.FinancesRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinancesService implements EntityService<FinancesDto> {

    @Autowired
    private FinancesRepository repository;

    @Autowired
    private FinancesMapper mapper;

    public FinancesService(FinancesRepository repository, FinancesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FinancesDto create(FinancesDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public FinancesDto update(FinancesDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public FinancesDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<FinancesDto> getEntities() {
        List<Finances> result = new ArrayList<Finances>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }

    public FinancesDto getByTeamId(Long id){
        return mapper.toDto(repository.findByTeamFinancesId(id));
    }
}


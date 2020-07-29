package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.CountryDto;
import com.bsuir.vmsis.mapper.impl.CountryMapper;
import com.bsuir.vmsis.model.impl.Country;
import com.bsuir.vmsis.repository.CountryRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService implements EntityService<CountryDto>{

    @Autowired
    private CountryRepository repository;

    @Autowired
    private CountryMapper mapper;

    public CountryService(CountryRepository repository, CountryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CountryDto create(CountryDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public CountryDto update(CountryDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CountryDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<CountryDto> getEntities() {
        List<Country> result = new ArrayList<Country>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }
}


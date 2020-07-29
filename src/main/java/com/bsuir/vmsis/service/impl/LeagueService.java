package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.LeagueDto;
import com.bsuir.vmsis.mapper.impl.LeagueMapper;
import com.bsuir.vmsis.model.impl.League;
import com.bsuir.vmsis.repository.LeagueRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueService implements EntityService<LeagueDto> {

    @Autowired
    private LeagueRepository repository;

    @Autowired
    private LeagueMapper mapper;

    public LeagueService(LeagueRepository repository, LeagueMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public LeagueDto create(LeagueDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public LeagueDto update(LeagueDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public LeagueDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<LeagueDto> getEntities() {
        List<League> result = new ArrayList<League>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }
}
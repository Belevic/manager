package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.SquadDto;
import com.bsuir.vmsis.mapper.impl.LeagueMapper;
import com.bsuir.vmsis.mapper.impl.SquadMapper;
import com.bsuir.vmsis.model.impl.Season;
import com.bsuir.vmsis.model.impl.Squad;
import com.bsuir.vmsis.repository.LeagueRepository;
import com.bsuir.vmsis.repository.SquadRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SquadService implements EntityService<SquadDto> {

    @Autowired
    private SquadRepository repository;

    @Autowired
    private SquadMapper mapper;

    public SquadService(SquadRepository repository, SquadMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SquadDto create(SquadDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public SquadDto update(SquadDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public SquadDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<SquadDto> getEntities() {
        List<Squad> result = new ArrayList<Squad>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }

    public SquadDto getByTeamId(Long id){
        return mapper.toDto(repository.findByTeamId(id));
    }
}

package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.TeamDto;
import com.bsuir.vmsis.mapper.impl.TeamMapper;
import com.bsuir.vmsis.model.impl.Team;
import com.bsuir.vmsis.repository.TeamRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamService implements EntityService<TeamDto>{

    @Autowired
    private TeamRepository repository;

    @Autowired
    private TeamMapper mapper;

    public TeamService(TeamRepository repository, TeamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TeamDto create(TeamDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public TeamDto update(TeamDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TeamDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<TeamDto> getEntities() {
        return null;
    }

    public List<TeamDto> getByLeagueIdEntities(Long id){
        List<Team> result = new ArrayList<Team>();
        repository.findByLeagueId(id).forEach(result::add);
        return (mapper.listToDto(result));
    }

    public List<TeamDto> getSortedTeamsByLeagueId(Long id){
        Comparator<TeamDto> comparator = Comparator.comparingLong(TeamDto::getPoints)
                .reversed().thenComparing(TeamDto::getScored)
                .reversed().thenComparing(TeamDto::getAgainst)
                .reversed().thenComparing(TeamDto::getName);
        List<TeamDto> result = getByLeagueIdEntities(id);
        Collections.sort(result,comparator);
        return result;
    }

    public TeamDto getTeamByManagerId(long id){
        return mapper.toDto(repository.findByManagerId(id));
    }
}
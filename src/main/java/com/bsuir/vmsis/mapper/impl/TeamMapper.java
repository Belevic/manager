package com.bsuir.vmsis.mapper.impl;

import com.bsuir.vmsis.dto.impl.LeagueDto;
import com.bsuir.vmsis.dto.impl.TeamDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Team;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper implements CustomMapper<TeamDto,Team> {

    @Autowired
    private ModelMapper mapper;

    public TeamMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TeamDto toDto(Team team) {
        return mapper.map(team, TeamDto.class);
    }

    @Override
    public Team fromDto(TeamDto teamDto) {
        return mapper.map(teamDto,Team.class);
    }

    @Override
    public List<TeamDto> listToDto(List<Team> entities) {
        return entities.stream().map(team -> toDto(team)).collect(Collectors.toList());
    }

    @Override
    public List<Team> listFromDto(List<TeamDto> dtos) {
        return dtos.stream().map(team -> fromDto(team)).collect(Collectors.toList());
    }
}

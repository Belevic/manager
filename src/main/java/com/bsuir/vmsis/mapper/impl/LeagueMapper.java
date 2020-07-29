package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.CountryDto;
import com.bsuir.vmsis.dto.impl.LeagueDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Country;
import com.bsuir.vmsis.model.impl.League;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LeagueMapper implements CustomMapper<LeagueDto, League> {

    @Autowired
    private ModelMapper mapper;

    public LeagueMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public LeagueDto toDto(League league) {
        return mapper.map(league,LeagueDto.class);
    }

    @Override
    public League fromDto(LeagueDto leagueDto) {
        return mapper.map(leagueDto,League.class);
    }

    @Override
    public List<LeagueDto> listToDto(List<League> entities) {
        return entities.stream().map(league -> toDto(league)).collect(Collectors.toList());
    }

    @Override
    public List<League> listFromDto(List<LeagueDto> dtos) {
        return dtos.stream().map(league -> fromDto(league)).collect(Collectors.toList());
    }
}

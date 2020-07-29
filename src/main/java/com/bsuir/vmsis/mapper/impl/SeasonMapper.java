package com.bsuir.vmsis.mapper.impl;

import com.bsuir.vmsis.dto.impl.LeagueDto;
import com.bsuir.vmsis.dto.impl.SeasonDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.League;
import com.bsuir.vmsis.model.impl.Season;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeasonMapper implements CustomMapper<SeasonDto, Season> {

    @Autowired
    private ModelMapper mapper;

    public SeasonMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public SeasonDto toDto(Season season) {
        return mapper.map(season, SeasonDto.class);
    }

    @Override
    public Season fromDto(SeasonDto seasonDto) {
        return mapper.map(seasonDto, Season.class);
    }

    @Override
    public List<SeasonDto> listToDto(List<Season> entities) {
        return entities.stream().map(season -> toDto(season)).collect(Collectors.toList());
    }

    @Override
    public List<Season> listFromDto(List<SeasonDto> dtos) {
        return dtos.stream().map(season -> fromDto(season)).collect(Collectors.toList());
    }
}

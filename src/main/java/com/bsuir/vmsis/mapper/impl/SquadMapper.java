package com.bsuir.vmsis.mapper.impl;

import com.bsuir.vmsis.dto.impl.LeagueDto;
import com.bsuir.vmsis.dto.impl.SquadDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.League;
import com.bsuir.vmsis.model.impl.Squad;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SquadMapper implements CustomMapper<SquadDto, Squad> {

    @Autowired
    private ModelMapper mapper;

    public SquadMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public SquadDto toDto(Squad squad) {
        return mapper.map(squad, SquadDto.class);
    }

    @Override
    public Squad fromDto(SquadDto squadDto) {
        return mapper.map(squadDto, Squad.class);
    }

    @Override
    public List<SquadDto> listToDto(List<Squad> entities) {
        return entities.stream().map(squad -> toDto(squad)).collect(Collectors.toList());
    }

    @Override
    public List<Squad> listFromDto(List<SquadDto> dtos) {
        return dtos.stream().map(squad -> fromDto(squad)).collect(Collectors.toList());
    }
}

package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.MatchDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Match;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchMapper implements CustomMapper<MatchDto, Match> {

    @Autowired
    private ModelMapper mapper;

    public MatchMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MatchDto toDto(Match Match) {
        return mapper.map(Match,MatchDto.class);
    }

    @Override
    public Match fromDto(MatchDto MatchDto) {
        return mapper.map(MatchDto,Match.class);
    }

    @Override
    public List<MatchDto> listToDto(List<Match> entities) {
        return entities.stream().map(Match -> toDto(Match)).collect(Collectors.toList());
    }

    @Override
    public List<Match> listFromDto(List<MatchDto> dtos) {
        return dtos.stream().map(Match -> fromDto(Match)).collect(Collectors.toList());
    }
}


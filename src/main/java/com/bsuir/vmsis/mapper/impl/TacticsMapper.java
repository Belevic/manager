package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.TacticsDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Tactics;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TacticsMapper implements CustomMapper<TacticsDto, Tactics> {

    @Autowired
    private ModelMapper mapper;

    public TacticsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TacticsDto toDto(Tactics Tactics) {
        return mapper.map(Tactics, TacticsDto.class);
    }

    @Override
    public Tactics fromDto(TacticsDto TacticsDto) {
        return mapper.map(TacticsDto, Tactics.class);
    }

    @Override
    public List<TacticsDto> listToDto(List<Tactics> entities) {
        return entities.stream().map(Tactics -> toDto(Tactics)).collect(Collectors.toList());
    }

    @Override
    public List<Tactics> listFromDto(List<TacticsDto> dtos) {
        return dtos.stream().map(Tactics -> fromDto(Tactics)).collect(Collectors.toList());
    }
}

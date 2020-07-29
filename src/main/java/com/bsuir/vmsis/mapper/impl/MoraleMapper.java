package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.MoraleDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Morale;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MoraleMapper implements CustomMapper<MoraleDto, Morale> {

    @Autowired
    private ModelMapper mapper;

    public MoraleMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MoraleDto toDto(Morale Morale) {
        return mapper.map(Morale,MoraleDto.class);
    }

    @Override
    public Morale fromDto(MoraleDto MoraleDto) {
        return mapper.map(MoraleDto,Morale.class);
    }

    @Override
    public List<MoraleDto> listToDto(List<Morale> entities) {
        return entities.stream().map(Morale -> toDto(Morale)).collect(Collectors.toList());
    }

    @Override
    public List<Morale> listFromDto(List<MoraleDto> dtos) {
        return dtos.stream().map(Morale -> fromDto(Morale)).collect(Collectors.toList());
    }
}


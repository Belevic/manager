package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.PaceDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Pace;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaceMapper implements CustomMapper<PaceDto, Pace> {

    @Autowired
    private ModelMapper mapper;

    public PaceMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PaceDto toDto(Pace Pace) {
        return mapper.map(Pace,PaceDto.class);
    }

    @Override
    public Pace fromDto(PaceDto PaceDto) {
        return mapper.map(PaceDto,Pace.class);
    }

    @Override
    public List<PaceDto> listToDto(List<Pace> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Pace> listFromDto(List<PaceDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}

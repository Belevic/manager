package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.PassingDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Passing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassingMapper implements CustomMapper<PassingDto, Passing> {

    @Autowired
    private ModelMapper mapper;

    public PassingMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PassingDto toDto(Passing Passing) {
        return mapper.map(Passing,PassingDto.class);
    }

    @Override
    public Passing fromDto(PassingDto PassingDto) {
        return mapper.map(PassingDto,Passing.class);
    }

    @Override
    public List<PassingDto> listToDto(List<Passing> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Passing> listFromDto(List<PassingDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}


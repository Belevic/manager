package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.PhysicalDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Physical;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhysicalMapper implements CustomMapper<PhysicalDto, Physical> {

    @Autowired
    private ModelMapper mapper;

    public PhysicalMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PhysicalDto toDto(Physical Physical) {
        return mapper.map(Physical,PhysicalDto.class);
    }

    @Override
    public Physical fromDto(PhysicalDto PhysicalDto) {
        return mapper.map(PhysicalDto,Physical.class);
    }

    @Override
    public List<PhysicalDto> listToDto(List<Physical> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Physical> listFromDto(List<PhysicalDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}


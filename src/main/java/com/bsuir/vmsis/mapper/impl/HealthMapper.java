package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.HealthDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Health;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HealthMapper implements CustomMapper<HealthDto, Health> {

    @Autowired
    private ModelMapper mapper;

    public HealthMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public HealthDto toDto(Health Health) {
        return mapper.map(Health,HealthDto.class);
    }

    @Override
    public Health fromDto(HealthDto HealthDto) {
        return mapper.map(HealthDto,Health.class);
    }

    @Override
    public List<HealthDto> listToDto(List<Health> entities) {
        return entities.stream().map(Health -> toDto(Health)).collect(Collectors.toList());
    }

    @Override
    public List<Health> listFromDto(List<HealthDto> dtos) {
        return dtos.stream().map(Health -> fromDto(Health)).collect(Collectors.toList());
    }
}


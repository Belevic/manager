package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.ShootingDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Shooting;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShootingMapper implements CustomMapper<ShootingDto, Shooting> {

    @Autowired
    private ModelMapper mapper;

    public ShootingMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ShootingDto toDto(Shooting Shooting) {
        return mapper.map(Shooting,ShootingDto.class);
    }

    @Override
    public Shooting fromDto(ShootingDto ShootingDto) {
        return mapper.map(ShootingDto,Shooting.class);
    }

    @Override
    public List<ShootingDto> listToDto(List<Shooting> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Shooting> listFromDto(List<ShootingDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}


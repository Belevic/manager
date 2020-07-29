package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.FixtureDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Fixture;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FixtureMapper implements CustomMapper<FixtureDto, Fixture> {

    @Autowired
    private ModelMapper mapper;

    public FixtureMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public FixtureDto toDto(Fixture Fixture) {
        return mapper.map(Fixture,FixtureDto.class);
    }

    @Override
    public Fixture fromDto(FixtureDto FixtureDto) {
        return mapper.map(FixtureDto,Fixture.class);
    }

    @Override
    public List<FixtureDto> listToDto(List<Fixture> entities) {
        return entities.stream().map(Fixture -> toDto(Fixture)).collect(Collectors.toList());
    }

    @Override
    public List<Fixture> listFromDto(List<FixtureDto> dtos) {
        return dtos.stream().map(Fixture -> fromDto(Fixture)).collect(Collectors.toList());
    }
}


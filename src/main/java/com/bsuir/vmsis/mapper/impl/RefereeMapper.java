package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.RefereeDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Referee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RefereeMapper implements CustomMapper<RefereeDto, Referee> {

    @Autowired
    private ModelMapper mapper;

    public RefereeMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public RefereeDto toDto(Referee Referee) {
        return mapper.map(Referee,RefereeDto.class);
    }

    @Override
    public Referee fromDto(RefereeDto RefereeDto) {
        return mapper.map(RefereeDto,Referee.class);
    }

    @Override
    public List<RefereeDto> listToDto(List<Referee> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Referee> listFromDto(List<RefereeDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}


package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.LineUpDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.LineUp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LineUpMapper implements CustomMapper<LineUpDto, LineUp> {

    @Autowired
    private ModelMapper mapper;

    public LineUpMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public LineUpDto toDto(LineUp LineUp) {
        return mapper.map(LineUp,LineUpDto.class);
    }

    @Override
    public LineUp fromDto(LineUpDto LineUpDto) {
        return mapper.map(LineUpDto,LineUp.class);
    }

    @Override
    public List<LineUpDto> listToDto(List<LineUp> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<LineUp> listFromDto(List<LineUpDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}

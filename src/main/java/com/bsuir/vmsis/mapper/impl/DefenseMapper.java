package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.DefenseDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Defense;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefenseMapper implements CustomMapper<DefenseDto, Defense> {

    @Autowired
    private ModelMapper mapper;

    public DefenseMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public DefenseDto toDto(Defense Defense) {
        return mapper.map(Defense,DefenseDto.class);
    }

    @Override
    public Defense fromDto(DefenseDto DefenseDto) {
        return mapper.map(DefenseDto,Defense.class);
    }

    @Override
    public List<DefenseDto> listToDto(List<Defense> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Defense> listFromDto(List<DefenseDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}

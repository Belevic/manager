package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.FinancesDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Finances;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FinancesMapper implements CustomMapper<FinancesDto, Finances> {

    @Autowired
    private ModelMapper mapper;

    public FinancesMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public FinancesDto toDto(Finances Finances) {
        return mapper.map(Finances,FinancesDto.class);
    }

    @Override
    public Finances fromDto(FinancesDto FinancesDto) {
        return mapper.map(FinancesDto,Finances.class);
    }

    @Override
    public List<FinancesDto> listToDto(List<Finances> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Finances> listFromDto(List<FinancesDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}

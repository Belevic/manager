package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.DribblingDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Dribbling;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DribblingMapper implements CustomMapper<DribblingDto, Dribbling> {

    @Autowired
    private ModelMapper mapper;

    public DribblingMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public DribblingDto toDto(Dribbling Dribbling) {
        return mapper.map(Dribbling,DribblingDto.class);
    }

    @Override
    public Dribbling fromDto(DribblingDto DribblingDto) {
        return mapper.map(DribblingDto,Dribbling.class);
    }

    @Override
    public List<DribblingDto> listToDto(List<Dribbling> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Dribbling> listFromDto(List<DribblingDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}

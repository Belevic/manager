package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.PlayerPriceDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.PlayerPrice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerPriceMapper implements CustomMapper<PlayerPriceDto, PlayerPrice> {

    @Autowired
    private ModelMapper mapper;

    public PlayerPriceMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PlayerPriceDto toDto(PlayerPrice PlayerPrice) {
        return mapper.map(PlayerPrice,PlayerPriceDto.class);
    }

    @Override
    public PlayerPrice fromDto(PlayerPriceDto PlayerPriceDto) {
        return mapper.map(PlayerPriceDto,PlayerPrice.class);
    }

    @Override
    public List<PlayerPriceDto> listToDto(List<PlayerPrice> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<PlayerPrice> listFromDto(List<PlayerPriceDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}



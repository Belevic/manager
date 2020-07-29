package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.CountryDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Country;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper implements CustomMapper<CountryDto, Country> {

    @Autowired
    private ModelMapper mapper;

    public CountryMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CountryDto toDto(Country country) {
        return mapper.map(country,CountryDto.class);
    }

    @Override
    public Country fromDto(CountryDto countryDto) {
        return mapper.map(countryDto,Country.class);
    }

    @Override
    public List<CountryDto> listToDto(List<Country> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Country> listFromDto(List<CountryDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}

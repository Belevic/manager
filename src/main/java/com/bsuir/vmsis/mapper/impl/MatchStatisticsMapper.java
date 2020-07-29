package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.MatchStatisticsDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.MatchStatistics;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchStatisticsMapper implements CustomMapper<MatchStatisticsDto, MatchStatistics> {

    @Autowired
    private ModelMapper mapper;

    public MatchStatisticsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MatchStatisticsDto toDto(MatchStatistics MatchStatistics) {
        return mapper.map(MatchStatistics,MatchStatisticsDto.class);
    }

    @Override
    public MatchStatistics fromDto(MatchStatisticsDto MatchStatisticsDto) {
        return mapper.map(MatchStatisticsDto,MatchStatistics.class);
    }

    @Override
    public List<MatchStatisticsDto> listToDto(List<MatchStatistics> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<MatchStatistics> listFromDto(List<MatchStatisticsDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}

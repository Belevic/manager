package com.bsuir.vmsis.mapper.impl;

import com.bsuir.vmsis.dto.impl.TrainingDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Training;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingMapper implements CustomMapper<TrainingDto, Training> {

    @Autowired
    private ModelMapper mapper;

    public TrainingMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TrainingDto toDto(Training Training) {
        return mapper.map(Training, TrainingDto.class);
    }

    @Override
    public Training fromDto(TrainingDto TrainingDto) {
        return mapper.map(TrainingDto,Training.class);
    }

    @Override
    public List<TrainingDto> listToDto(List<Training> entities) {
        return entities.stream().map(Training -> toDto(Training)).collect(Collectors.toList());
    }

    @Override
    public List<Training> listFromDto(List<TrainingDto> dtos) {
        return dtos.stream().map(Training -> fromDto(Training)).collect(Collectors.toList());
    }
}

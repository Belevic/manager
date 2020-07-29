package com.bsuir.vmsis.mapper.impl;


import com.bsuir.vmsis.dto.impl.TransferDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Transfer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransferMapper implements CustomMapper<TransferDto, Transfer> {

    @Autowired
    private ModelMapper mapper;

    public TransferMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TransferDto toDto(Transfer Transfer) {
        return mapper.map(Transfer,TransferDto.class);
    }

    @Override
    public Transfer fromDto(TransferDto TransferDto) {
        return mapper.map(TransferDto,Transfer.class);
    }

    @Override
    public List<TransferDto> listToDto(List<Transfer> entities) {
        return entities.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Transfer> listFromDto(List<TransferDto> dtos) {
        return dtos.stream().map(author -> fromDto(author)).collect(Collectors.toList());
    }
}


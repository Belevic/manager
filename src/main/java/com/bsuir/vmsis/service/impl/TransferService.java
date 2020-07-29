package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.TransferDto;
import com.bsuir.vmsis.mapper.impl.TransferMapper;
import com.bsuir.vmsis.model.impl.Transfer;
import com.bsuir.vmsis.repository.TransferRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService implements EntityService<TransferDto> {

    @Autowired
    private TransferRepository repository;

    @Autowired
    private TransferMapper mapper;

    public TransferService(TransferRepository repository, TransferMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TransferDto create(TransferDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public TransferDto update(TransferDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TransferDto getById(Long id) {
        return null;
    }

    @Override
    public List<TransferDto> getEntities() {
        List<Transfer> result = new ArrayList<Transfer>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }
}



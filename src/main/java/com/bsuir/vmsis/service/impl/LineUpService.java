package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.LineUpDto;
import com.bsuir.vmsis.mapper.impl.LineUpMapper;
import com.bsuir.vmsis.model.impl.LineUp;
import com.bsuir.vmsis.repository.LineUpRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineUpService implements EntityService<LineUpDto> {

    @Autowired
    private LineUpRepository repository;

    @Autowired
    private LineUpMapper mapper;

    public LineUpService(LineUpRepository repository, LineUpMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public LineUpDto create(LineUpDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public LineUpDto update(LineUpDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public LineUpDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<LineUpDto> getEntities() {
        List<LineUp> result = new ArrayList<LineUp>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }

    public LineUpDto getByTeamId(Long id){
        return mapper.toDto(repository.findByTeamLineUpId(id));
    }
}

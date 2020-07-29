package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.SeasonDto;
import com.bsuir.vmsis.service.impl.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/season")
public class SeasonController {

    @Autowired
    SeasonService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeasonDto create(@Valid @RequestBody SeasonDto seasonDto) {
        return service.create(seasonDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeasonDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody SeasonDto seasonDto) {
        seasonDto.setId(id);
        return service.update(seasonDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeasonDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SeasonDto> searchAll() {
        return service.getEntities();
    }
}

package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.SquadDto;
import com.bsuir.vmsis.service.impl.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/squad")
@CrossOrigin(origins = { "http://localhost:3000"})
public class SquadController {

    @Autowired
    private SquadService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SquadDto create(@Valid @RequestBody SquadDto squadDto) {
        return service.create(squadDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SquadDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody SquadDto squadDto) {
        squadDto.setId(id);
        return service.update(squadDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SquadDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SquadDto> searchAll() {
        return service.getEntities();
    }
    
    @GetMapping("/team/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SquadDto searchByTeamId(@PathVariable @Min(1) Long id) {
        return service.getByTeamId(id);
    }
}

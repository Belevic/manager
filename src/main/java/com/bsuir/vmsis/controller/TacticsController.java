package com.bsuir.vmsis.controller;


import com.bsuir.vmsis.dto.impl.SquadDto;
import com.bsuir.vmsis.dto.impl.TacticsDto;
import com.bsuir.vmsis.service.impl.TacticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/tactics")
@CrossOrigin(origins = { "http://localhost:3000"})
public class TacticsController {

    @Autowired
    private TacticsService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TacticsDto create (@Valid @RequestBody TacticsDto tacticsDto){
        return service.create(tacticsDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TacticsDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody TacticsDto tacticsDto){
        tacticsDto.setId(id);
        return service.update(tacticsDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TacticsDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TacticsDto> searchAll() {
        return service.getEntities();
    }

    @GetMapping("/team/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TacticsDto searchByTeamId(@PathVariable @Min(1) Long id) {
        return service.getByTeamId(id);
    }
}

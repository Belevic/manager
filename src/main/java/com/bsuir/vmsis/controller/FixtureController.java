package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.FixtureDto;
import com.bsuir.vmsis.dto.impl.FixtureDto;
import com.bsuir.vmsis.dto.impl.MatchDto;
import com.bsuir.vmsis.dto.impl.MatchStatisticsDto;
import com.bsuir.vmsis.model.impl.MatchStatistics;
import com.bsuir.vmsis.service.impl.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/fixture")
@CrossOrigin(origins = { "http://localhost:3000"})
public class FixtureController {

    @Autowired
    private FixtureService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FixtureDto create(@Valid @RequestBody FixtureDto fixtureDto) {
        return service.create(fixtureDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FixtureDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody FixtureDto fixtureDto) {
        fixtureDto.setId(id);
        return service.update(fixtureDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FixtureDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping("/match/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchDto> searchByFixtureId(@PathVariable @Min(1) Long id) {
        return service.getByFixtureId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FixtureDto> searchAll() {
        return service.getEntities();
    }

    @GetMapping("/play/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void playFixtureMatches(@PathVariable @Min(1) Long id){
        service.fixtureMatchesGenerateResults(id);
    }

    @GetMapping("/shedule/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void generateFixtureShedule(@PathVariable @Min(1) Long id){
        service.generateFixtureShedule(id);
    }
}

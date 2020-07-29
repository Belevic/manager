package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.MatchDto;
import com.bsuir.vmsis.dto.impl.MatchStatisticsDto;
import com.bsuir.vmsis.model.impl.MatchStatistics;
import com.bsuir.vmsis.service.impl.MatchService;
import com.bsuir.vmsis.service.impl.MatchStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/match")
@CrossOrigin(origins = { "http://localhost:3000"})
public class MatchController {

    @Autowired
    private MatchService service;

    @Autowired
    private MatchStatisticsService statisticsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatchDto create (@Valid @RequestBody MatchDto MatchDto){
        return service.create(MatchDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody MatchDto matchDto){
        matchDto.setId(id);
        return service.update(matchDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MatchDto> searchAll() {
        return service.getEntities();
    }

    @GetMapping("/team/{id}/{fixtureId}")
    @ResponseStatus(HttpStatus.OK)
    public MatchDto searchByTeamId(@PathVariable @Min(1) Long id, @PathVariable @Min(1) Long fixtureId) {
        return service.getByHomeOrGuestTeamId(id,fixtureId);
    }
    @GetMapping("/group")
    @ResponseStatus(HttpStatus.OK)
    public List<List<MatchDto>> getMatchesGroupByFixture() {
        return service.getMatchesGroupByFixture();
    }

    @GetMapping("/shedule/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void generateMatchShedule(@Valid @PathVariable Long id) {
        /*service.generateMatchShedule(id);*/
    }

    @GetMapping("/stats/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchStatisticsDto> getMatchStatistics(@Valid @PathVariable Long id) {
        return statisticsService.getByMatchId(id);
    }

    @GetMapping("/stats/all/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<List<MatchStatisticsDto>> getMatchStatisticsByFixtureId(@Valid @PathVariable Long id) {
        return statisticsService.getMatchesStatsByFixtureId(id);
    }
}


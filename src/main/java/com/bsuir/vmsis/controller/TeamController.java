package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.TeamDto;
import com.bsuir.vmsis.service.impl.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/team")
@CrossOrigin(origins = { "http://localhost:3000"})
public class TeamController {

    @Autowired
    private TeamService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto create(@Valid @RequestBody TeamDto teamDto) {
        return service.create(teamDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody TeamDto teamDto) {
        teamDto.setId(id);
        return service.update(teamDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDto> searchAll() {
        return service.getEntities();
    }
    
    @GetMapping("/league/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDto> searchAllInLeague(@PathVariable @Min(1) Long id) {
        return service.getByLeagueIdEntities(id);
    }

    @GetMapping("/manager/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamDto searchTeamByManagerId(@PathVariable @Min(1) Long id) {
        return service.getTeamByManagerId(id);
    }

    @GetMapping("/sort/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDto> getSortedTeamsByLeagueId(@PathVariable @Min(1) Long id) {
        return service.getSortedTeamsByLeagueId(id);
    }
}

package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.LeagueDto;
import com.bsuir.vmsis.service.impl.CountryService;
import com.bsuir.vmsis.service.impl.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/league")
@CrossOrigin(origins = "*",maxAge=3600)
public class LeagueController {

    @Autowired
    private LeagueService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LeagueDto create (@Valid @RequestBody LeagueDto leagueDto){
        return service.create(leagueDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeagueDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody LeagueDto leagueDto){
        leagueDto.setId(id);
        return service.update(leagueDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeagueDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LeagueDto> searchAll() {
        return service.getEntities();
    }
}

package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.*;
import com.bsuir.vmsis.service.impl.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/player")
@CrossOrigin(origins = { "http://localhost:3000"})
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDto create(@Valid @RequestBody PlayerDto playerDto) {
        return service.create(playerDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody PlayerDto playerDto) {
        playerDto.setId(id);
        return service.update(playerDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDto> searchAll() {
        return service.getEntities();
    }

    @GetMapping("/squad/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDto> searchBySquadId(@PathVariable @Min(1) Long id) {
        return service.getBySquadId(id);
    }

    @GetMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDto> searchOnTransfer() {
        return service.getOnTransfer(true);
    }

    @GetMapping("/dribbling/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DribblingDto getPlayerDribbling(@PathVariable @Min(1) Long id) {
        return service.getOverallDribbling(id);
    }

    @GetMapping("/shooting/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShootingDto getPlayerShooting(@PathVariable @Min(1) Long id) {
        return service.getPlayerShooting(id);
    }

    @GetMapping("/pace/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaceDto getPlayerPace(@PathVariable @Min(1) Long id) {
        return service.getPlayerPace(id);
    }

    @GetMapping("/defense/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DefenseDto getPlayerDefense(@PathVariable @Min(1) Long id) {
        return service.getPlayerDefense(id);
    }

    @GetMapping("/passing/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassingDto countPlayerPassing(@PathVariable @Min(1) Long id) {
        return service.getPlayerPassing(id);
    }

    @GetMapping("/physical/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PhysicalDto countPlayerPhysical(@PathVariable @Min(1) Long id) {
        return service.getPlayerPhysical(id);
    }
}

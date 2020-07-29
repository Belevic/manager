package com.bsuir.vmsis.controller;


import com.bsuir.vmsis.dto.impl.LineUpDto;
import com.bsuir.vmsis.dto.impl.SquadDto;
import com.bsuir.vmsis.service.impl.LineUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/lineUp")
@CrossOrigin(origins = { "http://localhost:3000"})
public class LineUpController {

    @Autowired
    private LineUpService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LineUpDto create (@Valid @RequestBody LineUpDto lineUpDto){
        return service.create(lineUpDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LineUpDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody LineUpDto lineUpDto){
        lineUpDto.setId(id);
        return service.update(lineUpDto);
    }

    @GetMapping("/team/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LineUpDto searchByTeamId(@PathVariable @Min(1) Long id) {
        return service.getByTeamId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LineUpDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LineUpDto> searchAll() {
        return service.getEntities();
    }
}

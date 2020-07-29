package com.bsuir.vmsis.controller;
import com.bsuir.vmsis.dto.impl.FinancesDto;
import com.bsuir.vmsis.dto.impl.FinancesDto;
import com.bsuir.vmsis.service.impl.FinancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/finances")
@CrossOrigin(origins = { "http://localhost:3000"})
public class FinancesController {

    @Autowired
    private FinancesService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FinancesDto create(@Valid @RequestBody FinancesDto FinancesDto) {
        return service.create(FinancesDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FinancesDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody FinancesDto FinancesDto) {
        FinancesDto.setId(id);
        return service.update(FinancesDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FinancesDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FinancesDto> searchAll() {
        return service.getEntities();
    }

    @GetMapping("/team/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FinancesDto searchByTeamId(@PathVariable @Min(1) Long id) {
        return service.getByTeamId(id);
    }
}

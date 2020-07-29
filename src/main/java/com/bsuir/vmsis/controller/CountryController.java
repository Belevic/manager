package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.CountryDto;
import com.bsuir.vmsis.service.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/country")
@CrossOrigin(origins = { "http://localhost:3000"})
public class CountryController {

    @Autowired
    private CountryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryDto create(@Valid @RequestBody CountryDto countryDto) {
        return service.create(countryDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CountryDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody CountryDto countryDto) {
        countryDto.setId(id);
        return service.update(countryDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CountryDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CountryDto> searchAll() {
        return service.getEntities();
    }
}

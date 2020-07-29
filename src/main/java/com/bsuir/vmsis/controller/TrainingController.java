package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.TrainingDto;
import com.bsuir.vmsis.service.impl.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/training")
@CrossOrigin(origins = { "http://localhost:3000"})
public class TrainingController {

    @Autowired
    private TrainingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingDto create(@Valid @RequestBody TrainingDto trainingDto) {
        return service.create(trainingDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainingDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody TrainingDto trainingDto) {
        trainingDto.setId(id);
        return service.update(trainingDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainingDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrainingDto> searchAll() {
        return service.getEntities();
    }
    
    @GetMapping("/team/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainingDto searchAllInLeague(@PathVariable @Min(1) Long id) {
        return service.getByTeamId(id);
    }
}

package com.bsuir.vmsis.controller;

import com.bsuir.vmsis.dto.impl.TransferDto;
import com.bsuir.vmsis.service.impl.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/transfer")
@CrossOrigin(origins = { "http://localhost:3000"})
public class TransferController {

    @Autowired
    private TransferService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransferDto create(@Valid @RequestBody TransferDto transferDto) {
        return service.create(transferDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransferDto update(@PathVariable @Min(1) Long id, @Valid @RequestBody TransferDto transferDto) {
        transferDto.setId(id);
        return service.update(transferDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransferDto searchById(@PathVariable @Min(1) Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransferDto> searchAll() {
        return service.getEntities();
    }
}


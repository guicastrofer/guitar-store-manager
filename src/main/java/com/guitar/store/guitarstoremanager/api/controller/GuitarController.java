package com.guitar.store.guitarstoremanager.api.controller;

import com.guitar.store.guitarstoremanager.api.model.GuitarInput;
import com.guitar.store.guitarstoremanager.api.model.GuitarOutput;
import com.guitar.store.guitarstoremanager.domain.entity.Guitar;
import com.guitar.store.guitarstoremanager.domain.exception.GuitarNotFoundException;
import com.guitar.store.guitarstoremanager.domain.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/guitars")
public class GuitarController {

    private GuitarService guitarService;

    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guitar create(@RequestBody @Valid GuitarInput guitarInput){
        return guitarService.create(guitarInput);
    }

    @GetMapping("/{id}")
    public GuitarOutput findById(@PathVariable Long id) throws GuitarNotFoundException {
        return guitarService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) throws GuitarNotFoundException {
        guitarService.delete(id);
    }

}

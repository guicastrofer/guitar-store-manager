package com.guitar.store.guitarstoremanager.controller;

import com.guitar.store.guitarstoremanager.dto.GuitarDTO;
import com.guitar.store.guitarstoremanager.dto.MessageResponseDTO;
import com.guitar.store.guitarstoremanager.exception.GuitarNotFoundException;
import com.guitar.store.guitarstoremanager.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public MessageResponseDTO create(@RequestBody @Valid GuitarDTO guitarDTO){
        return guitarService.create(guitarDTO);
    }

    @GetMapping("/{id}")
    public GuitarDTO findById(@PathVariable Long id) throws GuitarNotFoundException {
        return guitarService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponseDTO delete(@PathVariable Long id) throws GuitarNotFoundException {
        GuitarDTO guitar = guitarService.findById(id);
        if(guitar!=null){
            return guitarService.delete(guitar,id);
        } else{
            throw new GuitarNotFoundException(id);
        }
    }

}

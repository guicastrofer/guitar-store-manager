package com.guitar.store.guitarstoremanager.controller;

import com.guitar.store.guitarstoremanager.dto.GuitarDTO;
import com.guitar.store.guitarstoremanager.dto.MessageResponseDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;
import com.guitar.store.guitarstoremanager.repository.GuitarRepository;
import com.guitar.store.guitarstoremanager.service.GuitarService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public GuitarDTO findById(@PathVariable Long id){
        return guitarService.findById(id);
    }

}

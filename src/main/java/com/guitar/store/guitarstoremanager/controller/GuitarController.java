package com.guitar.store.guitarstoremanager.controller;

import com.guitar.store.guitarstoremanager.dto.MessageResponseDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;
import com.guitar.store.guitarstoremanager.repository.GuitarRepository;
import com.guitar.store.guitarstoremanager.service.GuitarService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@RestController
@RequestMapping("/api/v1/guitars")
public class GuitarController {

    private GuitarService guitarService;

    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Guitar guitar){
        return guitarService.create(guitar);
    }

}

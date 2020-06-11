package com.guitar.store.guitarstoremanager.controller;

import com.guitar.store.guitarstoremanager.dto.MessageResponseDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;
import com.guitar.store.guitarstoremanager.repository.GuitarRepository;
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

    private GuitarRepository guitarRepository;

    @Autowired
    public GuitarController(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Guitar guitar){
        Guitar saveGuitar = guitarRepository.save(guitar);
        return MessageResponseDTO.builder().message("Guitar create with ID "
                +saveGuitar.getId()).build();
    }

}

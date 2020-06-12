package com.guitar.store.guitarstoremanager.service;

import com.guitar.store.guitarstoremanager.dto.MessageResponseDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;
import com.guitar.store.guitarstoremanager.repository.GuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuitarService {
    private GuitarRepository guitarRepository;

    @Autowired
    public GuitarService(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    public MessageResponseDTO create(Guitar guitar){
        Guitar saveGuitar = guitarRepository.save(guitar);
        return MessageResponseDTO.builder().message("Guitar create with ID "
                +saveGuitar.getId()).build();
    }
}

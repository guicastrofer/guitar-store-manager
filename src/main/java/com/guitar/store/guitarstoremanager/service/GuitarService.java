package com.guitar.store.guitarstoremanager.service;

import com.guitar.store.guitarstoremanager.dto.GuitarDTO;
import com.guitar.store.guitarstoremanager.dto.MessageResponseDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;
import com.guitar.store.guitarstoremanager.mapper.GuitarMapper;
import com.guitar.store.guitarstoremanager.repository.GuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuitarService {

    private GuitarRepository guitarRepository;

    private final GuitarMapper guitarMapper = GuitarMapper.INSTANCE;


    @Autowired
    public GuitarService(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    public MessageResponseDTO create(GuitarDTO guitarDTO){
        Guitar guitarToSave= guitarMapper.toModel(guitarDTO);

        Guitar savedGuitar = guitarRepository.save(guitarToSave);
        return MessageResponseDTO.builder()
                .message("Guitar create with ID "
                +savedGuitar.getId()).build();
    }

    public GuitarDTO findById(Long id) {
        Optional<Guitar> optionalGuitar = guitarRepository.findById(id);
        return guitarMapper.toDTO(optionalGuitar.get());
    }
}

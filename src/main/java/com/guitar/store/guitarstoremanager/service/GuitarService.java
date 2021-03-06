package com.guitar.store.guitarstoremanager.service;

import com.guitar.store.guitarstoremanager.dto.GuitarDTO;
import com.guitar.store.guitarstoremanager.dto.MessageResponseDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;
import com.guitar.store.guitarstoremanager.exception.GuitarNotFoundException;
import com.guitar.store.guitarstoremanager.mapper.GuitarMapper;
import com.guitar.store.guitarstoremanager.repository.GuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public GuitarDTO findById(Long id) throws GuitarNotFoundException {
        Guitar guitar = guitarRepository.findById(id)
                .orElseThrow(()-> new GuitarNotFoundException(id));

        return guitarMapper.toDTO(guitar);
    }

    public MessageResponseDTO delete(GuitarDTO guitarDTO, Long id) {
        guitarRepository.deleteById(id);
        return MessageResponseDTO.builder().message("Guitar deleted with ID "+guitarDTO.getId()).build();
    }
}

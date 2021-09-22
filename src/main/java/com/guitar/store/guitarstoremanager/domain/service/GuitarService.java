package com.guitar.store.guitarstoremanager.domain.service;

import com.guitar.store.guitarstoremanager.api.model.GuitarInput;
import com.guitar.store.guitarstoremanager.api.model.GuitarOutput;
import com.guitar.store.guitarstoremanager.domain.entity.Guitar;
import com.guitar.store.guitarstoremanager.domain.exception.GuitarNotFoundException;
import com.guitar.store.guitarstoremanager.domain.repository.GuitarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuitarService {

    private final GuitarRepository guitarRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public GuitarService(GuitarRepository guitarRepository, ModelMapper modelMapper) {
        this.guitarRepository = guitarRepository;
        this.modelMapper = modelMapper;
    }

    public Guitar create(GuitarInput guitarInput){
        return guitarRepository.save(toEntity(guitarInput));
    }

    public GuitarOutput findById(Long id) {
        Guitar guitar =  guitarRepository.findById(id)
                .orElseThrow(()-> new GuitarNotFoundException(id));
        return toModel(guitar);
    }

    public void delete(Long id) {
        findById(id);
        guitarRepository.deleteById(id);
    }

    public GuitarOutput toModel(Guitar guitar) {
        return modelMapper.map(guitar, GuitarOutput.class);
    }

    public Guitar toEntity(GuitarInput guitarInput) {
        return modelMapper.map(guitarInput, Guitar.class);
    }

}

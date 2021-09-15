package com.guitar.store.guitarstoremanager.domain.service;

import com.guitar.store.guitarstoremanager.api.model.GuitarInput;
import com.guitar.store.guitarstoremanager.api.model.GuitarModel;
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

    public GuitarModel findById(Long id) {
        Guitar guitar =  guitarRepository.findById(id)
                .orElseThrow(()-> new GuitarNotFoundException(id));
        return toModel(guitar);
    }

    public void delete(Long id) {
        findById(id);
        guitarRepository.deleteById(id);
    }

    public GuitarModel toModel(Guitar guitar) {
        return modelMapper.map(guitar, GuitarModel.class);
    }

    public Guitar toEntity(GuitarInput guitarInput) {
        return modelMapper.map(guitarInput, Guitar.class);
    }

}

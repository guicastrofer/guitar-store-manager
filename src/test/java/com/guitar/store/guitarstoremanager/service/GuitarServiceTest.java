package com.guitar.store.guitarstoremanager.service;

import com.guitar.store.guitarstoremanager.dto.GuitarDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;
import com.guitar.store.guitarstoremanager.repository.GuitarRepository;
import com.guitar.store.guitarstoremanager.utils.GuitarUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class GuitarServiceTest {

    @Mock
    private GuitarRepository guitarRepository;

    @InjectMocks
    private GuitarService guitarService;

    @Test
    void whenGivenExistingIdThenReturnThisGuitar(){
        Guitar expectedFoundGuitar = GuitarUtils.createFakeGuitar();
        Mockito.when(guitarRepository.findById(expectedFoundGuitar.getId())).thenReturn(Optional.of(expectedFoundGuitar));
        GuitarDTO guitarDTO = guitarService.findById(expectedFoundGuitar.getId());
        Assertions.assertEquals(expectedFoundGuitar.getName(),guitarDTO.getName());
        Assertions.assertEquals(expectedFoundGuitar.getStrings(),guitarDTO.getStrings());
    }
}

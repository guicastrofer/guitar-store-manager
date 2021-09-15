package com.guitar.store.guitarstoremanager.domain.service;

import com.guitar.store.guitarstoremanager.api.model.GuitarModel;
import com.guitar.store.guitarstoremanager.domain.entity.Guitar;
import com.guitar.store.guitarstoremanager.domain.exception.GuitarNotFoundException;
import com.guitar.store.guitarstoremanager.domain.repository.GuitarRepository;
import com.guitar.store.guitarstoremanager.utils.GuitarUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuitarServiceTest {

    @Mock
    private GuitarRepository guitarRepository;

    @InjectMocks
    private GuitarService guitarService;

    @Test
    void whenGivenExistingIdThenReturnThisGuitar() throws GuitarNotFoundException {
        Guitar expectedFoundGuitar = GuitarUtils.createFakeGuitar();
        Mockito.when(guitarRepository.findById(expectedFoundGuitar.getId())).thenReturn(Optional.of(expectedFoundGuitar));
        GuitarModel guitarModel = guitarService.findById(expectedFoundGuitar.getId());
        Assertions.assertEquals(expectedFoundGuitar.getName(), guitarModel.getName());
        Assertions.assertEquals(expectedFoundGuitar.getStrings(), guitarModel.getStrings());
    }

    @Test
    void whenGivenUnexistingIdThenNotFindThrowAnException() throws GuitarNotFoundException {
        var invalidId = 10L;

        when(guitarRepository.findById(invalidId))
                .thenReturn(Optional.ofNullable(any(Guitar.class)));

        assertThrows(GuitarNotFoundException.class, () ->guitarService.findById(invalidId));
    }
}

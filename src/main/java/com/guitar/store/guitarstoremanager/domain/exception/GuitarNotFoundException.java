package com.guitar.store.guitarstoremanager.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GuitarNotFoundException extends RuntimeException {

    public GuitarNotFoundException(Long id) {
        super(String.format("Guitar with Id "+id+" not found", id));
    }
}

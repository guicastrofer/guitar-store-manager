package com.guitar.store.guitarstoremanager.api.model;

import com.guitar.store.guitarstoremanager.domain.entity.Brand;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GuitarInput {

    @NotNull
    private String name;

    @NotNull
    private Integer string;

    @NotNull
    private Integer year;

    @NotNull
    private BrandDTO brandDTO;


}

package com.guitar.store.guitarstoremanager.api.model;

import com.guitar.store.guitarstoremanager.domain.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuitarInput {

    @NotNull
    private String name;

    @NotNull
    private Integer strings;

    @NotNull
    private Integer year;

    @NotNull
    private BrandDTO brand;


}

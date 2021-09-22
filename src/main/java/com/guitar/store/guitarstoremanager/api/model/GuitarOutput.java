package com.guitar.store.guitarstoremanager.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuitarOutput {

    private Long id;

    @NotBlank
    @Size(max=200)
    private String name;

    @NotNull
    private Integer strings;

    @NotNull
    private Long year;

    @Valid
    @NotNull
    private BrandDTO brand;

}

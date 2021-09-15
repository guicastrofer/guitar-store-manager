package com.guitar.store.guitarstoremanager.utils;

import com.github.javafaker.Faker;
import com.guitar.store.guitarstoremanager.api.model.BrandDTO;
import com.guitar.store.guitarstoremanager.domain.entity.Brand;

public class BrandUtils {

    private static final Faker faker = Faker.instance();

    public static BrandDTO createFakeBrandDTO() {
        return BrandDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().author())
                .serialNumber(faker.number().numberBetween(0, 200))
                .build();
    }

    public static Brand createFakeBrand() {
        return Brand.builder()
                .id(faker.number().randomNumber())
                .name(faker.name().firstName())
                .serialNumber(faker.number().numberBetween(0, 200))
                .build();
    }

    public static Brand createFakeBrandFrom(BrandDTO brandDTO) {
        return Brand.builder()
                .id(brandDTO.getId())
                .name(brandDTO.getName())
                .serialNumber(brandDTO.getSerialNumber())
                .build();
    }
}

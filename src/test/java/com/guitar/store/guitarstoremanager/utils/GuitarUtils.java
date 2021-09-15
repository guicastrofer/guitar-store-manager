package com.guitar.store.guitarstoremanager.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.guitar.store.guitarstoremanager.api.model.GuitarModel;
import com.guitar.store.guitarstoremanager.domain.entity.Guitar;

import static com.guitar.store.guitarstoremanager.utils.BrandUtils.*;

public class GuitarUtils {

    private static final Faker faker = Faker.instance();

    public static GuitarModel createFakeGuitarDTO() {
        return GuitarModel.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .strings(faker.number().numberBetween(0,12))
                .year(faker.number().numberBetween(1900l,2020l))
                .brand(createFakeBrandDTO())
                .build();
    }

    public static Guitar createFakeGuitar() {
        return Guitar.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .strings(faker.number().numberBetween(0,12))
                .year(faker.number().numberBetween(1900l,2020l))
                .brand(createFakeBrand())
                .build();
    }

    public static Guitar createFakeGuitarFrom(GuitarModel guitarModel) {
        return Guitar.builder()
                .id(guitarModel.getId())
                .name(guitarModel.getName())
                .strings(guitarModel.getStrings())
                .year(guitarModel.getYear())
                .brand(createFakeBrandFrom(guitarModel.getBrand()))
                .build();
    }

    public static String asJsonString(GuitarModel guitarModel) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(guitarModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

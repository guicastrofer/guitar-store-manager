package com.guitar.store.guitarstoremanager.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.guitar.store.guitarstoremanager.dto.GuitarDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;

import static com.guitar.store.guitarstoremanager.utils.BrandUtils.*;

public class GuitarUtils {

    private static final Faker faker = Faker.instance();

    public static GuitarDTO createFakeGuitarDTO() {
        return GuitarDTO.builder()
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

    public static Guitar createFakeGuitarFrom(GuitarDTO guitarDTO) {
        return Guitar.builder()
                .id(guitarDTO.getId())
                .name(guitarDTO.getName())
                .strings(guitarDTO.getStrings())
                .year(guitarDTO.getYear())
                .brand(createFakeBrandFrom(guitarDTO.getBrand()))
                .build();
    }

    public static String asJsonString(GuitarDTO guitarDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(guitarDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

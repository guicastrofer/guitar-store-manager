package com.guitar.store.guitarstoremanager.mapper;

import com.guitar.store.guitarstoremanager.dto.GuitarDTO;
import com.guitar.store.guitarstoremanager.entity.Guitar;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GuitarMapper {

    GuitarMapper INSTANCE = Mappers.getMapper(GuitarMapper.class) ;

    Guitar toModel(GuitarDTO guitarDTO);

    GuitarDTO toDTO(Guitar guitar);

}

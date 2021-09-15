package com.guitar.store.guitarstoremanager.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Getter
@Setter
@Builder
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @UniqueElements
    private String name;

    @NotNull
    @UniqueElements
    private Integer serialNumber;


}

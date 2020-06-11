package com.guitar.store.guitarstoremanager.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="NM_BRAND",nullable = false, unique = true)
    private String name;

    @Column(name ="SERIAL_NUMBER",nullable = false, unique = true)
    private Integer serialNumber;


}

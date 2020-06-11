package com.guitar.store.guitarstoremanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Guitar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NM_GUITAR",nullable = false)
    private String name;

    @Column(name="NB_STRINGS",nullable = false)
    private Integer strings;

    @Column(name="YEAR",nullable = false)
    private Long year;

    //Lazy allows performance a apply a inner join and 3 operations below at the same time.
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name ="brand_id")
    private Brand brand;

}

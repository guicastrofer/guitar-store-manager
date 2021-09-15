package com.guitar.store.guitarstoremanager.domain.repository;

import com.guitar.store.guitarstoremanager.domain.entity.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuitarRepository extends JpaRepository<Guitar,Long> {

}

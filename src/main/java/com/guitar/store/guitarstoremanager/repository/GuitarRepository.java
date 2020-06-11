package com.guitar.store.guitarstoremanager.repository;

import com.guitar.store.guitarstoremanager.entity.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuitarRepository extends JpaRepository<Guitar,Long> {
}

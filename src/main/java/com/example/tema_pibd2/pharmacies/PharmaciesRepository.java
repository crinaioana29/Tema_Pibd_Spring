package com.example.tema_pibd2.pharmacies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PharmaciesRepository
        extends JpaRepository <Pharmacies, Long> {
    Optional<Pharmacies> findLocationsByName(String name);

    Optional<Pharmacies> findPharmaciesByName(String name);

}

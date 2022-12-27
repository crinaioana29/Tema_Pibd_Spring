package com.example.tema_pibd2.locations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationsRepository
        extends JpaRepository <Locations, Long> {
    Optional<Locations> findLocationsByCounty(String county);
}

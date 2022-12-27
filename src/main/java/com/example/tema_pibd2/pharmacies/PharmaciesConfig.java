package com.example.tema_pibd2.pharmacies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PharmaciesConfig {
    @Bean("pharmacies")
    CommandLineRunner commandLineRunner(PharmaciesRepository repository) {
        return args ->  {
            Pharmacies catena = new Pharmacies(
                    "Catena",
                    2004
            );
            Pharmacies dr_max = new Pharmacies(
                    "Dr. Max",
                    2020
            );
//           repository.saveAll(
//                   List.of(catena, dr_max)
//           );
        };
    }
}
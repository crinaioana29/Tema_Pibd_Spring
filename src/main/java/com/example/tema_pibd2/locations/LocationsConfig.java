package com.example.tema_pibd2.locations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LocationsConfig {
    @Bean
    CommandLineRunner commandLineRunner(LocationsRepository repository) {
       return args ->  {
           Locations dambovita = new Locations(
                           "Dambovita",
                           "Targoviste"
                   );
           Locations constanta = new Locations(
                   "Constanta",
                   "Constanta"
           );
//           repository.saveAll(
//                   List.of(dambovita, constanta)
//           );
        };
    }
}

package com.example.tema_pibd2.pharmacies;

import com.example.tema_pibd2.employees.Employees;
import com.example.tema_pibd2.locations.Locations;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class PharmaciesConfig {
    @Bean("pharmacies")
    CommandLineRunner commandLineRunner(PharmaciesRepository repository) {
        return args ->  {
            Locations location1 = new Locations(
                    "Timis",
                    "Timisoara"
            );

            Employees employee1 = new Employees(
                    "Dobre",
                    "Vlad",
                    LocalDate.of(1997, Month.APRIL, 23),
                    LocalDate.of(2019, Month.AUGUST, 14)
            );

            Employees employee2 = new Employees(
                    "Duta",
                    "Ioana",
                    LocalDate.of(1995, Month.APRIL, 19),
                    LocalDate.of(2021, Month.AUGUST, 14)
            );
            List<Locations> locationsSet=new ArrayList<>();
            List<Employees> employeesSet=new ArrayList<>();
            locationsSet.add(location1);
            employeesSet.add(employee1);
            employeesSet.add(employee2);
            Pharmacies pharmacies=new Pharmacies("test",2005,locationsSet,employeesSet);
//           repository.saveAll(
//                   List.of(pharmacy1)
//           );
        };
    }
}
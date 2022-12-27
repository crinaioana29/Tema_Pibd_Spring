package com.example.tema_pibd2.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeesConfig {
    @Bean("employees")
    CommandLineRunner commandLineRunner(EmployeesRepository repository) {
        return args ->  {
            Employees popescu = new Employees(
                    "Popescu",
                    "Ioana",
                    LocalDate.of(1990, Month.FEBRUARY, 23),
                    LocalDate.of(2016, Month.JUNE, 26)
            );
            Employees ionescu = new Employees(
                    "Ionescu",
                    "Maria",
                    LocalDate.of(1998, Month.FEBRUARY, 5),
                    LocalDate.of(2021, Month.JUNE, 26)
            );
//           repository.saveAll(
//                   List.of(popescu, ionescu)
//           );
        };
    }
}

package com.example.tema_pibd2.employees;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepository
        extends JpaRepository <Employees, Long> {
    Optional<Employees> findEmployeesBySurname(String surname);
}
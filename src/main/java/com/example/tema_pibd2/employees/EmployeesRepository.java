package com.example.tema_pibd2.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface EmployeesRepository
        extends JpaRepository <Employees, Long> {
    Optional<Employees> findEmployeesBySurname(String surname);
}

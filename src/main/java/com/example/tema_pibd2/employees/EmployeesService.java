package com.example.tema_pibd2.employees;

import com.example.tema_pibd2.pharmacies.Pharmacies;
import com.example.tema_pibd2.pharmacies.PharmaciesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
//internal logic of the application
@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;
    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> getEmployees() {
        return employeesRepository.findAll();
    }
    public void addNewEmployee(Employees employee) {
        Optional<Employees> employeeOptional = employeesRepository
                .findEmployeesBySurname(employee.getSurname());
        employeesRepository.save(employee);
        System.out.println(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeesRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("employee with id " + employeeId + " does not exist");
        }
        employeesRepository.deleteById(employeeId);
    }

    @Transactional
//    to wrap a method in a database transaction
    public void updateEmployee(Long employeeId, String surname, String first_name) {
        Employees employee = employeesRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "employee with id " + employeeId + " does not exist"));
        if (surname != null && surname.length() > 0 && !Objects.equals(employee.getSurname(), surname)) {
            employee.setSurname(surname);
        }
        if (first_name != null && first_name.length() > 0 && !Objects.equals(employee.getFirst_name(), first_name)) {
            employee.setFirst_name(first_name);
        }
    }
}


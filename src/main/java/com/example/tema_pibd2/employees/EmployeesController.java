package com.example.tema_pibd2.employees;

import com.example.tema_pibd2.employees.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Employees")
public class EmployeesController {
    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping
    public List<Employees> getEmployees() {
        return employeesService.getEmployees();
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employees employee) {
        employeesService.addNewEmployee(employee);
    }
    @DeleteMapping(path  = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeesService.deleteEmployee(employeeId);
    }
    @PutMapping(path = "{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String first_name) {
        employeesService.updateEmployee(employeeId, surname, first_name);
    }
}

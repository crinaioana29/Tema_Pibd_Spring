package com.example.tema_pibd2.pharmacies;

import com.example.tema_pibd2.employees.Employees;
import com.example.tema_pibd2.employees.EmployeesService;
import com.example.tema_pibd2.locations.Locations;
import com.example.tema_pibd2.locations.LocationsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PharmaciesService {

    private final PharmaciesRepository pharmaciesRepository;
    private final EmployeesService employeesService;
    private final LocationsService locationsService;
    @Autowired
    public PharmaciesService(PharmaciesRepository pharmaciesRepository,
                             EmployeesService employeesService,
                             LocationsService locationsService) {
        this.pharmaciesRepository = pharmaciesRepository;
        this.employeesService = employeesService;
        this.locationsService = locationsService;
    }

    public List<Pharmacies> getPharmacies() {
        return pharmaciesRepository.findAll();
    }

    public void addNewPharmacy(Pharmacies pharmacy) {
        Locations aux=pharmacy.getLocation();
        aux.setPharmacy(pharmacy);
        Employees aux_employee=pharmacy.getEmployee();
        aux_employee.setPharmacy(pharmacy);
        pharmacy.addToLocationsList(aux);
        pharmacy.addToEmployeesList(aux_employee);
        pharmaciesRepository.save(pharmacy);
    }

    public void deletePharmacy(Long pharmacyId) {
        boolean exists = pharmaciesRepository.existsById(pharmacyId);
        if(!exists) {
            throw new IllegalStateException("pharmacy with id " + pharmacyId + " does not exist");
        }
        pharmaciesRepository.deleteById(pharmacyId);
    }
    @Transactional
    public void updatePharmacy(Long pharmacyId, String name, int est_year) {
        Pharmacies pharmacy = pharmaciesRepository.findById(pharmacyId)
                .orElseThrow(() -> new IllegalStateException(
                        "pharmacy with id " + pharmacyId + " does not exist"));
        if(name != null && name.length() > 0 && !Objects.equals(pharmacy.getName(), name)) {
            pharmacy.setName(name);
        }
        if(est_year != 0 && !Objects.equals(pharmacy.getEst_year(), est_year)) {
            pharmacy.setEst_year(est_year);
        }
    }
}
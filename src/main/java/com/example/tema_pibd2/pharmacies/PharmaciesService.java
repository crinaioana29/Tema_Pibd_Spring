package com.example.tema_pibd2.pharmacies;

import jakarta.transaction.Transactional;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PharmaciesService {

    private final PharmaciesRepository pharmaciesRepository;
    @Autowired
    public PharmaciesService(PharmaciesRepository pharmaciesRepository) {
        this.pharmaciesRepository = pharmaciesRepository;
    }

    public List<Pharmacies> getPharmacies() {
        return pharmaciesRepository.findAll();
    }
    public void addNewPharmacy(Pharmacies pharmacy) {
        Optional<Pharmacies> pharmacyOptional = pharmaciesRepository.
                findPharmaciesByName(pharmacy.getName());
        if(pharmacyOptional.isPresent()) {
            throw new IllegalStateException("county taken");
        }
        pharmaciesRepository.save(pharmacy);
        System.out.println(pharmacy);
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
package com.example.tema_pibd2.pharmacies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Pharmacies")
public class PharmaciesController {
    private final PharmaciesService pharmaciesService;

    @Autowired
    public PharmaciesController(PharmaciesService pharmaciesService) {
        this.pharmaciesService = pharmaciesService;
    }

    @GetMapping
    public List<Pharmacies> getPharmacies() {
        return pharmaciesService.getPharmacies();
    }

    @PostMapping
    public void registerNewPharmacy(@RequestBody Pharmacies pharmacy) {
        pharmaciesService.addNewPharmacy(pharmacy);
    }
    @DeleteMapping(path  = "{pharmacyId}")
    public void deletePharmacy(@PathVariable("pharmacyId") Long pharmacyId) {
        pharmaciesService.deletePharmacy(pharmacyId);
    }
    @PutMapping(path = "{pharmacyId}")
    public void updatePharmacy(
            @PathVariable("pharmacyId") Long pharmacyId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int est_year) {
        pharmaciesService.updatePharmacy(pharmacyId, name, est_year);
    }
}
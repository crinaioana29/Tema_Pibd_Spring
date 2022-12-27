package com.example.tema_pibd2.pharmacies;

import com.example.tema_pibd2.employees.Employees;
import com.example.tema_pibd2.locations.Locations;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Pharmacies {
    @SequenceGenerator(
            name = "pharmacies_sequence",
            sequenceName = "pharmacies_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "pharmacies_sequence"
    )

    @OneToMany(mappedBy = "locations")
    @JsonIgnore
    Set<Locations> locationsSet;
    @OneToMany(mappedBy = "employees")
    @JsonIgnore
    Set<Employees> employeesSet;

    @Id
    private Long idpharmacy;
    private String name;
    private int est_year;
//defaul constructor
    public Pharmacies() {
    }

    public Pharmacies(Long idpharmacy,
                      String name,
                      int est_year) {
        this.idpharmacy = idpharmacy;
        this.name = name;
        this.est_year = est_year;
    }

    public Pharmacies(String name, int est_year) {
        this.name = name;
        this.est_year = est_year;
    }

    public Long getIdpharmacy() {
        return idpharmacy;
    }

    public void setIdpharmacy(Long idpharmacy) {
        this.idpharmacy = idpharmacy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEst_year() {
        return est_year;
    }

    public void setEst_year(int est_year) {
        this.est_year = est_year;
    }

    @Override
    public String toString() {
        return "Pharmacies{" +
                "idpharmacy=" + idpharmacy +
                ", name='" + name + '\'' +
                ", est_year=" + est_year +
                '}';
    }
}

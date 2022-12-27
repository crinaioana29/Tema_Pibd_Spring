package com.example.tema_pibd2.pharmacies;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Pharmacies {
    @Id
    @SequenceGenerator(
            name = "pharmacies_sequence",
            sequenceName = "phamacies_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "pharmacies_sequence"
    )
    private Long idpharmacy;
    private String name;
    private LocalDate est_year;
//defaul constructor
    public Pharmacies() {
    }

    public Pharmacies(Long idpharmacy,
                      String name,
                      LocalDate est_year) {
        this.idpharmacy = idpharmacy;
        this.name = name;
        this.est_year = est_year;
    }

    public Pharmacies(String name, LocalDate est_year) {
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

    public LocalDate getEst_year() {
        return est_year;
    }

    public void setEst_year(LocalDate est_year) {
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

package com.example.tema_pibd2.locations;

import com.example.tema_pibd2.pharmacies.Pharmacies;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
// This tells Hibernate to make a table out of this class
public class Locations {
    @Id
    @SequenceGenerator(
            name = "locations_sequence",
            sequenceName = "locations_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "locations_sequence"
    )
    private Long idlocation;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idpharmacy")
    @JsonIgnore
    Pharmacies pharmacy;

    public Pharmacies getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacies pharmacy) {
        this.pharmacy = pharmacy;
    }

    private String county;
    private String city;
//default constructor
    public Locations() {
    }

    public Locations(Long idlocation, String county, String city) {
        this.idlocation = idlocation;
        this.county = county;
        this.city = city;
    }

    public Locations(String county, String city) {
        this.county = county;
        this.city = city;
    }

    public Long getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(Long idlocation) {
        this.idlocation = idlocation;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
//    method is used to return a string representation of an object
    public String toString() {
        return "Locations{" +
                "idlocation=" + idlocation +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

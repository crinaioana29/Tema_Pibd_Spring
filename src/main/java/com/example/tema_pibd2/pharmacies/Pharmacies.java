package com.example.tema_pibd2.pharmacies;

import com.example.tema_pibd2.employees.Employees;
import com.example.tema_pibd2.locations.Locations;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
// This tells Hibernate to make a table out of this class
public class Pharmacies {
//    sets the primary key (@Id)
    @Id
//    generates a table with an autoincremented sequence
    @SequenceGenerator(
            name = "pharmacies_sequence",
            sequenceName = "pharmacies_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "pharmacies_sequence"
    )
    private Long idpharmacy;
    private String name;
    private int est_year;
    @Transient
    private Locations location;
    @Transient
    private Employees employee;
    @Transient
    Long aux_id;
    @OneToMany(mappedBy ="pharmacy",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Locations> locations;
    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Employees> employees;
//default constructor
    public Pharmacies() {
        locations=new ArrayList<>();
        employees=new ArrayList<>();
    }

    public Pharmacies(Long idpharmacy,
                      String name,
                      int est_year,
                      List<Locations> locations,
                      List<Employees> employees) {
        this.idpharmacy = idpharmacy;
        this.name = name;
        this.est_year = est_year;
        this.locations = locations;
        this.employees = employees;
    }

    public Pharmacies(String name,
                      int est_year,
                      List<Locations> locations,
                      List<Employees> employees) {
        this.name = name;
        this.est_year = est_year;
        this.locations = locations;
        this.employees = employees;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }
    public void addToLocationsList(Locations location){
        this.locations.add(location);
    }
    public void addToEmployeesList(Employees employee,Long index){
        this.employees.set(Math.toIntExact(index),employee);
    }

    public void addToEmployeesList(Employees employee){
        this.employees.add(employee);
    }
    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
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

    public Long getAux_id() {
        return aux_id;
    }

    public void setAux_id(Long aux_id) {
        this.aux_id = aux_id;
    }

    @Override
//    method is used to return a string representation of an object
//    an implicit method
    public String toString() {
        return "Pharmacies{" +
                "idpharmacy=" + idpharmacy +
                ", name='" + name + '\'' +
                ", est_year=" + est_year +
                '}';
    }
}

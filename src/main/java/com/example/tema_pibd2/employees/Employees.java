package com.example.tema_pibd2.employees;

import com.example.tema_pibd2.pharmacies.Pharmacies;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
// This tells Hibernate to make a table out of this class
public class Employees {
//    sets the primary key (@Id)
    @Id
//    generates a table with an autoincremented sequence
    @SequenceGenerator(
            name = "employees_sequence",
            sequenceName = "employees_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "employees_sequence"
    )
    private Long idemployee;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idpharmacy")
    @JsonIgnore
    Pharmacies pharmacy;
    private String surname;
    private String first_name;
    private LocalDate date_of_birth;
    private LocalDate empl_year;

    @Transient
    private Long ph_id;
//default constructor
    public Employees() {
    }

    public Employees(Long idemployee,
                     String surname,
                     String first_name,
                     LocalDate date_of_birth,
                     LocalDate empl_year) {
        this.idemployee = idemployee;
        this.surname = surname;
        this.first_name = first_name;
        this.date_of_birth = date_of_birth;
        this.empl_year = empl_year;
    }
//constructor cu un obiect de tipul pharmacies
    public Employees(
                     String surname,
                     String first_name,
                     LocalDate date_of_birth,
                     LocalDate empl_year) {
        this.surname = surname;
        this.first_name = first_name;
        this.date_of_birth = date_of_birth;
        this.empl_year = empl_year;
    }


    public Pharmacies getPharmacy() {
        return pharmacy;
    }
    public Long getPharmacyId(){
        return pharmacy.getIdpharmacy();
    }
    public void setPharmacy(Pharmacies pharmacy) {
        this.pharmacy = pharmacy;
    }
    public Long getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(Long idemployee) {
        this.idemployee = idemployee;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public LocalDate getEmpl_year() {
        return empl_year;
    }

    public void setEmpl_year(LocalDate empl_year) {
        this.empl_year = empl_year;
    }

    public Long getPh_id() {
        return ph_id;
    }

    public void setPh_id(Long ph_id) {
        this.ph_id = ph_id;
    }

    @Override
//    method used to return a string representation of an object
//    an implicit method
    public String toString() {
        return "Employees{" +
                "idemployee=" + idemployee +
                ", surname='" + surname + '\'' +
                ", first_name='" + first_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", empl_year=" + empl_year +
                '}';
    }
}

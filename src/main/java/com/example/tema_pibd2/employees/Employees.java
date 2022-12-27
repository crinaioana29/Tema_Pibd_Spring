package com.example.tema_pibd2.employees;

import java.time.LocalDate;

public class Employees {
    private Long idemployee;
    private String surname;
    private String first_name;
    private LocalDate date_of_birth;
    private LocalDate empl_year;
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

    public Employees(String surname,
                     String first_name,
                     LocalDate date_of_birth,
                     LocalDate empl_year) {
        this.surname = surname;
        this.first_name = first_name;
        this.date_of_birth = date_of_birth;
        this.empl_year = empl_year;
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

    @Override
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

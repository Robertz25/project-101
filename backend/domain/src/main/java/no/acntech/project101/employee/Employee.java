package no.acntech.project101.employee;

import jakarta.persistence.*;
import no.acntech.project101.company.Company;

import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;

    @Column(name = "companyid")
    private Long companyId;

    //TODO Create the enitity for Employee
    public Employee(Long id, String firstname, String lastname, LocalDate date_of_birth, Long companyId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date_of_birth = date_of_birth;
        this.companyId = companyId;
    }

    public Employee(String firstName, String lastName, LocalDate date_of_birth, Long companyId) {
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Employee() {


    }

    public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
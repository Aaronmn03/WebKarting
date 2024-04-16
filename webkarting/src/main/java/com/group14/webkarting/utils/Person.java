package com.group14.webkarting.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long person_id;
    
    @OneToOne
    @JoinColumn(name = "dni_id")
    private DNI dni;
    private String name;
    private String surname;

    public Person(DNI dni, String name, String surname){
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    public Person(Person person){
        this.dni = person.getDni();
        this.name = person.getName();
        this.surname = person.getSurname();
    }

    public Person() {
        
    }

    public DNI getDni() {
        return dni;
    }

    public void setDni(DNI dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

}
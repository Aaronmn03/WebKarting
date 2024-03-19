package com.group14.webkarting.utils;

public class Person {
    private DNI dni;
    private String name;
    private String surname;

    //@Entity
    public Person(DNI dni, String name, String surname){
        this.dni = dni;
        this.name = name;
        this.surname = surname;
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
    

}
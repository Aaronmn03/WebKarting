package com.group14.webkarting;

import com.group14.webkarting.utils.DNI;

public class Persona {
    private DNI dni;
    private String nombre;
    private String apellidos;

    @Entity
    public Persona(DNI dni, String nombre, String apellidos){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public DNI getDni() {
        return dni;
    }

    public void setDni(DNI dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    

}
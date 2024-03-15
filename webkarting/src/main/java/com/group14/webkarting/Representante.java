package com.group14.webkarting;

import com.group14.webkarting.utils.Correo;
import com.group14.webkarting.utils.DNI;
import com.group14.webkarting.utils.Telefono;

public class Representante extends Persona{

    private Correo correo;
    private Telefono telefono;
    public Representante(DNI dni, String nombre, String apellidos) {
        super(dni, nombre, apellidos);
    }

    public Representante(DNI dni, String nombre, String apellidos,Correo correo, Telefono telefono){
        this(dni, nombre, apellidos);
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo.getCorreo();
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono.getTelefono();
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    
    
}

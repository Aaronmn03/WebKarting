package com.group14.webkarting.utils;

public class Representant extends Person{

    private Mail correo;
    private Phone telefono;

    public Representant(DNI dni, String nombre, String apellidos,Mail correo, Phone telefono){
        super(dni, nombre, apellidos);
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo.getCorreo();
    }

    public void setCorreo(Mail correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono.getTelefono();
    }

    public void setTelefono(Phone telefono) {
        this.telefono = telefono;
    }
    
    
}

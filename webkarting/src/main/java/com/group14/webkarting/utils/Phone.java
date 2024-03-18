package com.group14.webkarting.utils;

public class Phone {
    private int telefono;

    public Phone(int telefono) {
        if(Integer.toString(telefono).length() != 9){
            throw new IllegalArgumentException("El numero introducido no existe");
        }
        
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return Integer.toString(telefono);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Phone other = (Phone) obj;
        if (telefono != other.telefono)
            return false;
        return true;
    }
    
}

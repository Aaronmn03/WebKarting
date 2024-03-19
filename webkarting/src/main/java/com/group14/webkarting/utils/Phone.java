package com.group14.webkarting.utils;

public class Phone {
    private int phone;

    public Phone(int phone) {
        if(Integer.toString(phone).length() != 9){
            throw new IllegalArgumentException("El numero introducido no existe");
        }
        
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return Integer.toString(phone);
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
        if (phone != other.phone)
            return false;
        return true;
    }
    
}

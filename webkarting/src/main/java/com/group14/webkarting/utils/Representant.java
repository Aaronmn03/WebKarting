package com.group14.webkarting.utils;

public class Representant extends Person{

    private Mail mail;
    private Phone phone;

    public Representant(DNI dni, String name, String surname,Mail mail, Phone phone){
        super(dni, name, surname);
        this.mail = mail;
        this.phone = phone;
    }

    public String getMail() {
        return mail.getMail();
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public int getPhone() {
        return phone.getPhone();
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    
    
}
